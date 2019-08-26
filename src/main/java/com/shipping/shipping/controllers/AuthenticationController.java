package com.shipping.shipping.controllers;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.services.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
@Api(tags = {"Аутентификация"}, description = "API для аутентификации")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @ApiOperation("Производит вход в систему. Возвращает объект user если логин и пароль верны, либо сообщение об ошибке в противном случае")
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password){
        if(authenticationService.isCorrect(username, password)){
            return ResponseEntity.ok(authenticationService.loginObject(username, password));
        }else{
            return ResponseEntity.ok("Incorrect username or password");
        }
    }

    @ApiOperation("Возвращает список пользователей по роли")
    @GetMapping("getUsersByRole")
    public ResponseEntity<?> getUsersByRole(@RequestParam Role role){
        return ResponseEntity.ok(authenticationService.getUsersByRole(role));
    }
}
