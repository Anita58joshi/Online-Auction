package com.nepalaya.onlineauction.services;

import com.nepalaya.onlineauction.model.User;
import com.nepalaya.onlineauction.repository.dtos.Auth;
import com.nepalaya.onlineauction.repository.dtos.UserRegistrationResponse;
import com.nepalaya.onlineauction.repository.dtos.request.UserRequest;

public interface UserService {
    User getUser(Long id);

    User validateCredentials(Auth auth);

    UserRegistrationResponse processSignUp(UserRequest request);
}
