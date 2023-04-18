package com.api.controllers;

import com.api.interfaces.UserClient;
import com.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Make a request to Project 2 to get the user by id
        User user = userClient.getUserById(id);

        if (user == null) {
            // Return 404 Not Found if the user does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return the user to the client
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Other controller methods for updating, deleting, and listing users
}

