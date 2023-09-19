package com.maomao.service;

import com.maomao.pojo.User;

public interface UserService {
    User getUser(User user);

    Boolean register(User user);

    User getUserById(Integer uid);

    void updateUser(User user);

    Integer getUserCount();
}
