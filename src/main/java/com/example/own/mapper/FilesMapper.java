package com.example.own.mapper;

import com.example.own.entity.Files;
import com.example.own.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-02
 */
@Mapper
public interface FilesMapper extends BaseMapper<Files> {
    Role getRoleById(@Param("id") Integer id);
}
