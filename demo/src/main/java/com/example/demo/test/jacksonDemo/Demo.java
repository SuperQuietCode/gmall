package com.example.demo.test.jacksonDemo;


import com.example.demo.test.entity.Student;
import com.example.demo.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * jackson的使用
 *
 * @author ZhaoXin
 * @date 2020/9/30 11:04
 */
public class Demo {
    public static void main(String[] args) throws IOException {

        // java对象转化为json
        Person person = new Person("张三", 20);
        String result = JsonUtil.objToJson(person);
        System.out.println(result); // {"age":20,"userName":"张三"}

        // 将json转化为对象
        Person per = JsonUtil.stringToObj(result, Person.class);
        System.out.println(per);

        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new Hashtable<>();
        map.put("name", "zhangsan");
        mapList.add(map);
        String mapJson = JsonUtil.objToJson(mapList);
        System.out.println(mapJson);

        List<Map<String, Object>> mapP = JsonUtil.stringToObj(mapJson, List.class);
        mapP.forEach(s -> System.out.println(s));

        // 对象转换为json并格式化输出
        String s = JsonUtil.obj2StringPretty(person);
        System.out.println(s);

        String ss = JsonUtil.obj2StringPretty(mapList);
        System.out.println(ss);

        // 方式二Demo
        List<Person> perList = new ArrayList<>();
        perList.add(person);
        String perListJson = JsonUtil.objToJson(perList);
        List<Person> finalList = JsonUtil.stringToObj(perListJson, new TypeReference<List<Person>>() {
        });
        System.out.println(finalList);

        // 方式三Demo
        List<Student> finalList1 = JsonUtil.stringToObj(perListJson, List.class, Person.class);
        System.out.println(finalList1);
    }
}
