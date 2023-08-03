package com.example.own.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.own.controller.dto.Response;
import com.example.own.entity.User;

public interface IUserService extends IService<User> {

    Response login(Response response);

     User register(Response response);

}
