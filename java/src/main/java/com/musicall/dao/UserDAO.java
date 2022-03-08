package com.musicall.dao;

import com.musicall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface UserDAO {
    void register(User user);
    User findbyemail(String email);
    void update(User user);
}
