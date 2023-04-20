package com.oauth.services;

import com.oauth.model.User;
import com.oauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    // recebe um nome de usuário e retorna um objeto UserDetails.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implemente a lógica para carregar um usuário do banco de dados com base no nome de usuário fornecido.

        User user = userRepository.findByEmail(username);

        if(user == null) {
            logger.error("User not found: "+username);
            throw new UsernameNotFoundException("Email not found!");
        }

        logger.info("User found: "+username);

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}