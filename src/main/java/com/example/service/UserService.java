package com.example.service;


import com.example.model.User;

public interface UserService {

    User findByUserId(String userId);

    void save(User user);

}
