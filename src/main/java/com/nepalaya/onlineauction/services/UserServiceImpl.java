package com.nepalaya.onlineauction.services;

import com.nepalaya.onlineauction.model.User;
import com.nepalaya.onlineauction.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUser(Long id) {
        User response;
        try {
            response = this.repository.getById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return response;
    }
}
