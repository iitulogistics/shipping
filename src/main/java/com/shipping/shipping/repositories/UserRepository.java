package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    List<UserEntity> findUserEntitiesByRoles(Role role);
}
