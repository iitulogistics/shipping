package com.shipping.shipping.controllers;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.entities.UserEntity;
import com.shipping.shipping.repositories.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.WebServiceProvider;
import java.util.Collections;

@RestController
@RequestMapping("registration")
@Api(tags = "Регистрация", description = "Api для регистрации")
//@PreAuthorize("hasRole(Role.MANAGER)")
public class RegistrationController {
    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("addUser")
    public ResponseEntity<?> addUser(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam Role role) {
        if (userRepository.findByUsername(username) == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setActive(true);
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userEntity.setRoles(Collections.singleton(role));

            userRepository.save(userEntity);
            return ResponseEntity.ok("Пользователь добавлен");
        } else {
            return ResponseEntity.ok("Пользователь с таким именем существует");
        }
    }

    @PostMapping("deleteUserById")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) return ResponseEntity.ok("Пользователя с id = " + id + " не существует");
        userRepository.delete(userEntity);
        return ResponseEntity.ok("Пользователь с id = " + id + " удален");
    }

    @PostMapping("getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    @PostMapping("currentUser")
    public ResponseEntity<?> currentUser(@AuthenticationPrincipal UserEntity entity) {

        return ResponseEntity.ok(entity);

    }
}
