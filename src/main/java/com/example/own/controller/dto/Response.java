package com.example.own.controller.dto;

import lombok.Data;

@Data
public class Response {
    private Integer id;
    private String username;

    private String password;

    private String nickname;

    private String address;

    private String phone;


    private String token;

    private String createTime;

    private String role;

    private String avatarUrl;

}
