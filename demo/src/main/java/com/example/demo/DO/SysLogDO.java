package com.example.demo.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author ZhaoXin
 * @date 2021/6/9 16:20
 */
@Data
@TableName("sys_log")
public class SysLogDO {
    /**
     * 日志号
     */
    private String id;

    /**
     * 请求参数
     */
    private String request;

    /**
     * 响应参数
     */
    private String response;

    /**
     * 执行时长
     */
    private Date time;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 请求时间
     */
    private String requestDate;

    /**
     * 响应时间
     */
    private String responseDate;

    /**
     * 请求ip
     */
    private String requestIp;

    /**
     * 请求主机名
     */
    private String requestHostName;
}
