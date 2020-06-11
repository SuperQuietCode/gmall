package com.example.demo.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 学生实体类测试使用
 *
 * @author ZhaoXin
 * @date 2020/6/11 14:35
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
