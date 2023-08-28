package com.example.own.controller;

import com.example.own.common.Result;
import com.example.own.mapper.ClientMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对客户与客服之间的联系操作
 *
 * @author TD21260225杨继雷
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @Resource
    private ClientMapper clientMapper;

    @PostMapping("/add/{adminId}/{userId}")
    public Result add(@PathVariable("adminId") Integer adminId, @PathVariable("userId") Integer userId) {
        return Result.success(clientMapper.addNew(adminId, userId));
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer userId) {
        return Result.success(clientMapper.deleteByUserId(userId));
    }

    @GetMapping("/list/{id}")
    public Result list(@PathVariable("id") Integer adminId,
                       @RequestParam(defaultValue  = "") String input
    ){
        return Result.success(clientMapper.selectByAmdinId(adminId,input));
    }

}
