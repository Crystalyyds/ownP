package com.example.own.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.own.entity.Event;
import com.example.own.mapper.EventMapper;
import com.example.own.service.IEventService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-06
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {

}
