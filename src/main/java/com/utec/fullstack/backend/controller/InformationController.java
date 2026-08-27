package com.utec.fullstack.backend.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class InformationController {

    @GetMapping
    public String getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "Logged in as: " + userDetails.getUsername();
    }
}
