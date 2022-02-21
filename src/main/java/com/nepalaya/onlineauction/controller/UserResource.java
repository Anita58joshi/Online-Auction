package com.nepalaya.onlineauction.controller;

import com.nepalaya.onlineauction.model.User;
import com.nepalaya.onlineauction.repository.dtos.Auth;
import com.nepalaya.onlineauction.repository.dtos.UserRegistrationResponse;
import com.nepalaya.onlineauction.repository.dtos.request.UserRequest;
import com.nepalaya.onlineauction.services.api.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserInfo(@PathParam("id") @PathVariable Long id) {
        User response = null;
        try {
            response = this.userService.getUser(id);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("auth")
    public ResponseEntity<User> auth(@RequestBody Auth auth) {
        User response = null;
        try {
            response = this.userService.validateCredentials(auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<UserRegistrationResponse> signUp(@RequestBody UserRequest request) {
        UserRegistrationResponse response;
        try {
            response = this.userService.processSignUp(request);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

