package com.example.own.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-06
 */
@Getter
@Setter
@TableName("sys_event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;
    /**
     * 名字
     */
    private String name;

    /**
     * 时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;


    @TableField(value = "user_id")
    private Integer userId;


}
