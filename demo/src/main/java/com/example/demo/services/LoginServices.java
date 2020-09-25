package com.example.demo.services;

import com.example.demo.base.ResultStat;
import com.example.demo.VO.UserVO;

/**
 * @author ZhaoXin
 * @date 2020/9/25 13:45
 */
public interface LoginServices {

    ResultStat loginCheck(UserVO user);
}
