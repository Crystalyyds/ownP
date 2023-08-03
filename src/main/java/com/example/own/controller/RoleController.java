package com.example.own.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.own.common.Result;
import com.example.own.entity.Role;
import com.example.own.mapper.RoleMapper;
import com.example.own.service.IRoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {
    @Resource
    private IRoleService roleService;

    @PostMapping("/add")
    public Result add(@RequestBody Role role){
        return Result.success(roleService.saveOrUpdate(role));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(roleService.removeById(id));
    }

    @GetMapping("/list")
    public Result list(){
        return Result.success(roleService.list());
    }




}
