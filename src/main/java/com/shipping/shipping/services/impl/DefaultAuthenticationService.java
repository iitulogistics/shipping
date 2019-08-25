package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.entities.UserEntity;
import com.shipping.shipping.repositories.UserRepository;
import com.shipping.shipping.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAuthenticationService implements AuthenticationService {
    private final UserRepository userRepository;

    @Autowired
    public DefaultAuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isCorrect(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    @Override
    public UserEntity loginObject(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<UserEntity> getUsersByRole(Role role) {
        return userRepository.findUserEntitiesByRoles(role);
    }

}
