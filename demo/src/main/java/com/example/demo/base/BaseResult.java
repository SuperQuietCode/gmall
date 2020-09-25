package com.example.demo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 无返回数据的封装返回结果
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:52
 */
@Data
public class BaseResult implements Serializable {
    private Integer code;
    private String message;

    public BaseResult(ResultStat resultStat, String message) {
        this.code = resultStat.getCode();
        this.message = message;
    }
}
