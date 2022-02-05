package com.nepalaya.onlineauction.services;

import com.nepalaya.onlineauction.model.User;

@FunctionalInterface
public interface UserService {
    User getUser(Long id);
}
