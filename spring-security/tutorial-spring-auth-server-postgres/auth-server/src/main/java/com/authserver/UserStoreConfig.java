package com.authserver;


import com.authserver.models.UserModel;
import com.authserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class UserStoreConfig {

   @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {


        // Just a test! No make the same

        UserModel userModel = userRepository.findByUsername("user1").orElseThrow( () -> new UsernameNotFoundException("User Not Found with username: "+ "user1"));
        System.out.println("USER:" + userModel.getUsername());

//        List<UserModel> users = userRepository.findAll();
//
//        System.out.println("List:"+users.get(0).getUsername());


        var userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withUsername(userModel.getUsername())
                        .password("{noop}password")
                        .roles("USER")
                        .build());
        return userDetailsManager;
    }
}
