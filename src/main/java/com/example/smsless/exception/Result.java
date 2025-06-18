package com.example.smsless.exception;

import com.example.smsless.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code; // 200成功
    private String msg;
    private T data;



    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return  result;
    }
    public static Result<String> fail(String msg) {
        Result<String> result = new Result<>();
        result.setCode(400);
        result.setMsg(msg);
        result.setData(null);
        return new Result<>(400, msg, null);
    }
}
