package com.example.demo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 有返回数据的封装返回结果
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:55
 */
@Data
public class DataResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public DataResult(Object data, ResultStat resultStat, String message) {
        this.data = data;
        this.code = resultStat.getCode();
        this.message = message;
    }

}
