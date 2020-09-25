package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.base.BaseResult;
import com.example.demo.VO.UserVO;
import com.example.demo.services.LoginServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:39
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private LoginServices loginServices;

    @RequestMapping("/login")
    public BaseResult index(@RequestBody String payload) {
        UserVO user = JSON.parseObject(payload,UserVO.class);
        return loginServices.loginCheck(user).wrapBase();
    }
}
