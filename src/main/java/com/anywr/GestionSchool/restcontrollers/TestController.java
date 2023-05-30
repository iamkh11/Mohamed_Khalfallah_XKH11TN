package com.anywr.GestionSchool.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anywr.GestionSchool.repositories.UserRepository;
import com.anywr.GestionSchool.services.UserDetailsImpl;

import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping("/api/test")
@Log4j2
public class TestController {

    @Autowired 
    private UserRepository repository;


    @GetMapping("/profile")
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDetailsImpl profile() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    
        // log.info("Fullname: {}", userDetails.getFullname());

        return userDetails;
    }
}
