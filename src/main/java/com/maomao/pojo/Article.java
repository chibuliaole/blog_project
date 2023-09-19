package com.maomao.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    @Schema(name = "content",description = "具体内容")
    private String content;
    private Integer cid;
    private Integer uid;
    private Date createTime;
    private Date updateTime;
    private User user;

}
