package com.pollService.controller;

import com.pollService.model.User;
import com.pollService.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/getUserByUserId/{userId}")
    public User getUserByUserId(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
}
