package com.maomao.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String introduction;
    private Date createTime;
    private Date updateTime;
}
