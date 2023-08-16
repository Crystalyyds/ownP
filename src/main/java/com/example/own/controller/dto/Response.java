package com.example.own.controller.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Response {
    private Integer id;
    private String username;

    private String password;

    private String nickname;

    private String address;

    private String phone;


    private String location;



    private String token;

    private String createTime;

    private String role;

    private String avatarUrl;

}
