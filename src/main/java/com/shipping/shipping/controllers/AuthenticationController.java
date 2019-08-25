package com.shipping.shipping.controllers;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password){
        if(authenticationService.isCorrect(username, password)){
            return ResponseEntity.ok(authenticationService.loginObject(username, password));
        }else{
            return ResponseEntity.ok("Incorrect username or password");
        }
    }

    @GetMapping("getUsersByRole")
    public ResponseEntity<?> getUsersByRole(@RequestParam Role role){
        return ResponseEntity.ok(authenticationService.getUsersByRole(role));
    }
}
