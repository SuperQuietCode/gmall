package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:46
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -5872590402520464533L;

    private String id;
    private String userName;
    private String passWord;
    private String createTime;
    private String updateTime;
}
