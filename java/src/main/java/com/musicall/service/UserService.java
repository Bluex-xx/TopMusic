package com.musicall.service;

import com.musicall.entity.User;

public interface UserService {
    void register(User user);
    User findbyemail(String email);
    void update(User user);
}
