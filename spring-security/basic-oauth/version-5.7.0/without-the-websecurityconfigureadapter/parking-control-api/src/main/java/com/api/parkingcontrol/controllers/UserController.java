package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.configs.security.UserDetailsServiceImpl;
import com.api.parkingcontrol.dtos.UserModelDto;
import com.api.parkingcontrol.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    final UserDetailsServiceImpl userDetailsServiceImpl;

    public UserController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UserModelDto>> findAll(){
        List<UserModelDto> list = userDetailsServiceImpl.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserModelDto dto){
        System.out.println("dto: "+ dto);
        UserModelDto userModelDto = userDetailsServiceImpl.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userModelDto.getUserId()).toUri();

        return ResponseEntity.created(uri).body(userModelDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModelDto> findById(@PathVariable UUID id){
        UserModelDto dto = userDetailsServiceImpl.findById(id);

        UserModel userModel = new UserModel();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        Boolean role = Boolean.FALSE;

        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
             role = ((UserDetails)principal).getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        } else {
             username = principal.toString();
        }

//        System.out.println("ADMIN:"+role);
//        System.out.println("PRINCIPAL:"+principal.toString());
//        System.out.println("THE NAME: "+userDetailsServiceImpl.loadUserByUsername(dto.getUsername()));
//        System.out.println("THE DTO: "+dto.getUsername());
//        System.out.println("THE NAME: "+username);


        if(role){

            return ResponseEntity.ok().body(dto);
        }

        if( (!dto.getUsername().equals(username))){
            throw new AuthenticationServiceException("User not Authorized");
        }

        return ResponseEntity.ok().body(dto);
    }
}
