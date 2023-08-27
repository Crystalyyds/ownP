package com.example.own.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.own.entity.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper<Client> {
    @Delete("delete from sys_admin_user where user_id = #{userId}")
    int deleteByUserId(@Param("userId") Integer userId);

    @Select("select user_id from sys_admin_user where admin_id = #{adminId}")
    List<Integer> selectByAmdinId(@Param("adminId") Integer adminId);


    @Insert("insert into sys_admin_user(admin_id, user_id) values (#{adminId}, #{userId})")
    int addNew(@Param("adminId") Integer adminId, @Param("userId") Integer userId);

}
