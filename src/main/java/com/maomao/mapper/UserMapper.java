package com.maomao.mapper;

import com.maomao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUser(String username);

    void insertUser(User user);

    User getUserById(Integer uid);

    void updateUser(User user);

    Integer getUserCount();
}
