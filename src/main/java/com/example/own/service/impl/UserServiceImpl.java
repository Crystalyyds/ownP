package com.example.own.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.own.common.Constants;
import com.example.own.controller.dto.Response;
import com.example.own.entity.User;
import com.example.own.exception.ServiceException;
import com.example.own.mapper.UserMapper;
import com.example.own.service.IUserService;
import com.example.own.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Response login(Response response) {
        User one =getUserInfo(response);
        if(one!=null){
            BeanUtil.copyProperties(one, response,true);
            String token =  TokenUtils.genToken(one.getId().toString(),one.getPassword());
            response.setToken(token);
            return response;
        }else{
            throw new  ServiceException(Constants.CODE_401,"用户密码错误");
        }
    }

    @Override
    public User register(Response response) {
        User one = getUsersInfo(response);
        if (one==null){
            one= new User();
            BeanUtil.copyProperties(response,one);
            save(one);
        }else{
            throw new  ServiceException(Constants.CODE_400,"用户已经存在");
        }
        return  null;
    }

    private User getUserInfo(Response response){
        QueryWrapper<User> queryWrap = new QueryWrapper<>();
        queryWrap.eq("username",response.getUsername());
        queryWrap.eq("password",response.getPassword());
        User one;
        try{
            one = getOne(queryWrap);
        }catch (Exception e) {
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return  one;
    }

    private User getUsersInfo(Response response){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",response.getUsername());
        List<User> list = userMapper.selectList(wrapper);
        if(list.size()==0){
            return null;
        }else{
            User user  = getOne(wrapper);
            return user;
        }
    }

}
