package com.example.own.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_role")
public class RoleUser {
    @TableField("user_id")
    private Integer userId;
    @TableField("role_id")
    private Integer roleId;
}
