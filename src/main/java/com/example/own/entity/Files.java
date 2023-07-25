package com.example.own.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-02
 */
@Getter
@Setter
@TableName("sys_file")
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private String name;


    private String type;


    private Long size;


    private String url;


    private Boolean isDelete;


    private Boolean enable;


    private String md5;


}
