package com.shipping.shipping.services;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.entities.UserEntity;

import java.util.List;

public interface AuthenticationService {

    boolean isCorrect(String username, String password);

    UserEntity loginObject(String username, String password);

    List<UserEntity> getUsersByRole(Role role);
}
