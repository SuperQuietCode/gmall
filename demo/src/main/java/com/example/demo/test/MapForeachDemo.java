package com.example.demo.test;

import java.util.HashMap;
import java.util.Iterator;
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

        System.out.println("---------------------------");
        System.out.println("迭代器遍历");
        Iterator<Map.Entry<String, Object>> setIter = map.entrySet().iterator();
        while (setIter.hasNext()) {
            Map.Entry<String, Object> entry = setIter.next();
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
