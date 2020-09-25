package com.example.demo.test.redisTest;

import com.example.demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis测试
 *
 * @author ZhaoXin
 * @date 2020/9/25 10:23
 */
@Slf4j
@RestController
public class RedisDemo {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public Object getRedis() {
        redisUtil.set("test", "aaaaaa");
        return redisUtil.get("test");
    }
}
