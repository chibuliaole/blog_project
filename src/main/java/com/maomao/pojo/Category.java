package com.maomao.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer cid;
    private String cname;
    private Date createTime;
    private Date updateTime;
}
