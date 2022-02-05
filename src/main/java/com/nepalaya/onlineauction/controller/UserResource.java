package com.nepalaya.onlineauction.controller;

import com.nepalaya.onlineauction.model.User;
import com.nepalaya.onlineauction.services.UserService;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("user/{id}")
    public User ping(@PathParam("id") @PathVariable Long id) {
        User response = null;
        try {
            response = this.userService.getUser(id);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return response;
    }
}

