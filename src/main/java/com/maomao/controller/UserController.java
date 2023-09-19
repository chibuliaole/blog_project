package com.maomao.controller;

import com.maomao.pojo.User;
import com.maomao.service.UserService;
import com.maomao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
@Tag(name = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @Operation(summary = "用户登录")
    public Result login(@RequestBody User user){
        User userExist = userService.getUser(user);
        if(userExist != null){
            Map<String,Object> map = new HashMap<>();
            map.put("name",userExist.getUsername());
            map.put("uid",userExist.getUid());
            return Result.ok(map);
        }
        return Result.fail(null);
    }

    @PostMapping("register")
    @Operation(summary = "用户注册")
    public Result register(@RequestBody User user){
        Boolean flag = userService.register(user);
        if(flag){
            return Result.ok();
        }else{
            return Result.fail(null);
        }
    }

    @GetMapping("getUser/{uid}")
    @Operation(summary = "根据id查找用户")
    public Result getUserById(@PathVariable Integer uid){
        User user = userService.getUserById(uid);
        return Result.ok(user);
    }

    @PutMapping("updateUser")
    @Operation(summary = "修改用户")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.ok();
    }

    @Operation(summary = "查询用户总数")
    @GetMapping("/getUserCount")
    public Result getUserCount(){
        Integer count = userService.getUserCount();
        return Result.ok(count);
    }
}
