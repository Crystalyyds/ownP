package com.example.own.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.own.entity.Role;
import com.example.own.mapper.RoleMapper;
import com.example.own.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
