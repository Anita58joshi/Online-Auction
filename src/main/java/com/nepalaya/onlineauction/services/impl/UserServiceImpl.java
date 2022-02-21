package com.nepalaya.onlineauction.services.impl;

import com.nepalaya.onlineauction.model.User;
import com.nepalaya.onlineauction.model.enums.RegistrationStatus;
import com.nepalaya.onlineauction.repository.api.UserRepository;
import com.nepalaya.onlineauction.repository.dtos.Auth;
import com.nepalaya.onlineauction.repository.dtos.UserRegistrationResponse;
import com.nepalaya.onlineauction.repository.dtos.request.UserRequest;
import com.nepalaya.onlineauction.services.api.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Override
    public User validateCredentials(Auth auth) {
        List<User> user = new ArrayList<>();
        var userEntities = repository.findAll();
        userEntities.forEach(userEntity -> {
            if (Objects.equals(userEntity.getEmailAddress(), auth.getEmail()) && Objects.equals(userEntity.getPassword(), auth.getPassword())) {
                user.add(userEntity);
            }
        });
        if (user.size() > 1)
            throw new IllegalArgumentException("found multiple account");
        if (user.isEmpty())
            throw new IllegalArgumentException("invalid credentials");
        return user.get(0);
    }

    @Override
    public UserRegistrationResponse processSignUp(UserRequest request) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        try {
            this.validateRegistrationRequest(request);
            User user = this.toUser(request);
            System.out.println(user.getCreatedOn());
            this.repository.save(user);

        } catch (Exception e) {
            response.setStatus(RegistrationStatus.FAILED.name());
            return response;
        }
        this.processSendEmail(request);
        response.setStatus(RegistrationStatus.SUCCESS.name());
        return response;
    }

    private void processSendEmail(UserRequest request) {

    }

    private User toUser(UserRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setEmailAddress(request.getEmailAddress());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMiddleName(request.getMiddleName());
        user.setUsertype(request.getUsertype());
        user.setContactNo(request.getContactNo());
        user.setAddress(request.getAddress());
        user.setGenderType(request.getGenderType());
        user.setWallet(request.getWallet());
        user.setCreatedOn(LocalDate.now());
        return user;
    }

    private void validateRegistrationRequest(UserRequest request) {
        if (request.getEmailAddress() == null)
            throw new IllegalArgumentException("Invalid email");
        if (request.getEmailAddress().length() < 10)
            throw new IllegalArgumentException("Invalid email");
        if (!request.getPassword().equals(request.getConfirmPassword()))
            throw new IllegalArgumentException("Password did not match");
    }
}
