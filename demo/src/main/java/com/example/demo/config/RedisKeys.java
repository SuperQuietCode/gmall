package com.example.demo.config;

/**
 * 添加redisKey前缀方便区分
 *
 * @author ZhaoXin
 * @date 2020/9/25 11:21
 */
public enum RedisKeys {
    TEST("TEST_KEY#");

    private String key;
    RedisKeys(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
}
