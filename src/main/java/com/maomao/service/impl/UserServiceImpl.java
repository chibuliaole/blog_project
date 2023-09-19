package com.maomao.service.impl;

import com.maomao.mapper.UserMapper;
import com.maomao.pojo.User;
import com.maomao.service.UserService;
import com.maomao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        User selectUser = userMapper.selectUser(user.getUsername());
        if(selectUser != null){
            String userPassword = user.getPassword();
            String selectUserPassword = selectUser.getPassword();
            if(userPassword.equals(selectUserPassword)){
                return selectUser;
            }
            return null;
        }
        return null;
    }

    @Override
    public Boolean register(User user) {
        User selectUser = userMapper.selectUser(user.getUsername());
        if(selectUser == null){
            userMapper.insertUser(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getUserById(Integer uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);

    }

    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }
}
