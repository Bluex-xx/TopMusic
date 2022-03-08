package com.musicall.service.serviceimpl;

import com.musicall.dao.UserDAO;
import com.musicall.entity.User;
import com.musicall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public User findbyemail(String email) {
        return userDAO.findbyemail(email);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
