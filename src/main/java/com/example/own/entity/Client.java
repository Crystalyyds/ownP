package com.example.own.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_admin_user")
public class Client {
    @TableField("user_id")
    private Integer userId;
    @TableField("admin_id")
    private Integer adminId;
}
