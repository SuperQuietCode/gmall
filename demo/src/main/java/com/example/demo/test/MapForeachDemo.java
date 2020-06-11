package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * map的遍历方式
 *
 * @author ZhaoXin
 * @date 2020/6/11 16:16
 */
public class MapForeachDemo {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);

        // 使用lambda表达式的方式遍历
        map.forEach((key, value) -> System.out.println(key + "---" + value));

        System.out.println("---------------------------");

        for (Map.Entry<String, Object> m : map.entrySet()) {
            System.out.println(m.getKey() + "---" + m.getValue());
        }
    }
}
