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
import java.util.Optional;

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

    //@Transactional
    public UserModelDto insert(UserModelDto dto) {
        UserModel entity = new UserModel();
        // entity = configModelMapper.modelMapper().map(dto, UserModel.class);



        System.out.println("Entity value: "+entity.getRoles());
        System.out.println("Entity value: "+dto.getRoles().get(0).getRoleId());

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




}
