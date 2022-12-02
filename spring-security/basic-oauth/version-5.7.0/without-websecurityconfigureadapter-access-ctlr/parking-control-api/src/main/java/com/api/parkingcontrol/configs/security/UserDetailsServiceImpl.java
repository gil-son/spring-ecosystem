package com.api.parkingcontrol.configs.security;

import com.api.parkingcontrol.configs.ConfigModelMapper;
import com.api.parkingcontrol.dtos.RoleModelDto;
import com.api.parkingcontrol.dtos.UserModelDto;
import com.api.parkingcontrol.models.RoleModel;
import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.RoleRepository;
import com.api.parkingcontrol.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional // Necessary to load the database with relationship or modify the relationship to Eager
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ConfigModelMapper configModelMapper;




    // OAuth

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Will search in database the correspondent User
        UserModel userModel = userRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("User Not Found with username: "+username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }


    // Controller

    @Transactional(readOnly = true)
    public List<UserModelDto> findAll() {

        List<UserModel> list = userRepository.findAll();

        // Lambda
        List<UserModelDto> listDTO = list.stream().map( x -> new UserModelDto(x)).collect(Collectors.toList());

        return listDTO;
    }




    //@Transactional
    public UserModelDto insert(UserModelDto dto) {
        UserModel entity = new UserModel();
        // entity = configModelMapper.modelMapper().map(dto, UserModel.class);



        System.out.println("Entity value: "+entity.getRoles());
        System.out.println("Entity value: "+dto.getRoles().get(0).getRoleId());
        System.out.println("DTO Password: "+dto.getPassword());

        copyDtoToEntity(dto, entity);
        entity.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

        System.out.println("Entity value: "+entity.getRoles().get(0)+"Entity value: "+dto.getRoles().get(0));
        entity = userRepository.save(entity);
        return new UserModelDto(entity);
    }

    private void copyDtoToEntity(UserModelDto dto, UserModel entity) {
        entity.setUsername(dto.getUsername());
        entity.getRoles().clear();

        for(RoleModelDto roleDTO : dto.getRoles()) {
            Optional<RoleModel> verify = Optional.of(roleRepository.getById(roleDTO.getRoleId()));
            if(!verify.isPresent()){
                System.out.println("Not found ID:" + roleDTO.getRoleId());
            }

            RoleModel role = verify.get();
            entity.getRoles().add(role);
        }

    }


    //@Transactional(readOnly = true)
    public UserModelDto findById(UUID id) {
        Optional<UserModel> obj =  userRepository.findById(id);

        UserModel entity = obj.orElseThrow( () -> new UsernameNotFoundException("User Not Found with username"));

        return new UserModelDto(entity);
    }
}
