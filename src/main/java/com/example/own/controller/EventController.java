package com.example.own.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.own.common.Result;
import com.example.own.entity.Event;
import com.example.own.mapper.EventMapper;
import com.example.own.service.IEventService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private IEventService iEventService;

    @Resource
    private EventMapper eventMapper;

    @PostMapping("/add/{id}")
    public Result add(@RequestBody Event event, @PathVariable Integer id) {
        event.setCreateTime(new Date());
        return Result.success(iEventService.saveOrUpdate(event));
    }

    @GetMapping("/list")
    public Result Show(){
        return Result.success(iEventService.list());
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String username,
                           @RequestParam(defaultValue = "") String title,
                           @RequestParam(defaultValue = "") String content
    ) {
        IPage<Event> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Event> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)) {
            queryWrapper.like("name", username);
        }
        if (!"".equals(title)) {
            queryWrapper.like("title", title);
        }
        if (!"".equals(content)) {
            queryWrapper.like("content", content);
        }
        return Result.success(iEventService.page(page, queryWrapper));
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(iEventService.removeById(id));
    }

    @PostMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(iEventService.removeByIds(ids));
    }

    @GetMapping("/users/{id}")
    public Result getUsersInfo(@PathVariable Integer id) {
        return Result.success(eventMapper.getUserById(id));
    }

    @GetMapping("/get/{id}")
    public Result getContent(@PathVariable Integer id) {
        return Result.success(iEventService.getById(id));
    }
}

