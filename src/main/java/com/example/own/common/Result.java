package com.example.own.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //是否有效
    private Integer code;
    //原因
    private String msg;
    //数据
    private Object data;

    public static Result success() {
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(Integer code,String msg) {
        return new Result(code, msg, null);
    }
    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }
}
