package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.configs.security.UserDetailsServiceImpl;
import com.api.parkingcontrol.dtos.UserModelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    final UserDetailsServiceImpl userDetailsService;

    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserModelDto dto){
        System.out.println("dto: "+ dto);
        UserModelDto userModelDto = userDetailsService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userModelDto.getUserId()).toUri();

        return ResponseEntity.created(uri).body(userModelDto);
    }

}
