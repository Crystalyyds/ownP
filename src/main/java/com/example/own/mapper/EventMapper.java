package com.example.own.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.own.entity.Event;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-06
 */
public interface EventMapper extends BaseMapper<Event> {

    List<Event> getUserById(@Param("userid") Integer id);
}
