package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/data/user/{id}", method = RequestMethod.GET)
    public User session(@PathVariable("id") int id) {
        User user = userService.findById(Integer.toUnsignedLong(id));
        return user;
    }
}
