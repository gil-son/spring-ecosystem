package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

        @GetMapping("/notices")
        public String getLoansDetails() {
            return "Inquiry notices details are saved to the DB";

        } 
}
