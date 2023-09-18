package com.maomao.util;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(){}

    public static <T> Result<T> build(T data,Integer code ,String message){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static <T> Result<T> build(T data,ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> build(T data){
        Result<T> result = new Result<>();
        if(data!=null){
            result.setData(data);
        }
        return result;
    }



    public static <T> Result<T> ok(){
        return build(null,ResultCodeEnum.SUCCESS);
    }
    public static <T> Result<T> ok(T data){
        return build(data,ResultCodeEnum.SUCCESS);
    }
    public static <T> Result<T> fail(T data){
        return build(data,ResultCodeEnum.FAIL);
    }

}
