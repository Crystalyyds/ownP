package com.example.own.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_role")
@Data
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "role")
    private String role;

    private String name;

}
