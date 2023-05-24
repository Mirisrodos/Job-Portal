package com.oose.jobportal.controllers;

import com.oose.jobportal.constants.Domain;
import com.oose.jobportal.models.entities.User;
import com.oose.jobportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(Domain.CROSS_ORIGIN)
public class AccountController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        if(userService.findUserbyGmail(user.getGmail())) {
            return new ResponseEntity<String>("email already", HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            if(userService.saveUser(user)) {
                return new ResponseEntity<String>("success", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("false", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
