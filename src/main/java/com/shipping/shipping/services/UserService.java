package com.shipping.shipping.services;

import com.shipping.shipping.entities.Role;
import com.shipping.shipping.entities.UserEntity;
import com.shipping.shipping.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(s.equals("manager")){
            return new UserEntity(){{
                setId(0L);
                setActive(true);
                setUsername("manager");
                setPassword("manager");
                setRoles(Collections.singleton(Role.MANAGER));
            }};
        }
        return repository.findByUsername(s);
    }


}
