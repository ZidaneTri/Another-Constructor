package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String session(@RequestBody Object car) {
        car.getClass();
        car.toString();
        return "user";
    }
}
