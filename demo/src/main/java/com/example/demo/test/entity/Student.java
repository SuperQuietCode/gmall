package com.example.demo.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 学生实体类测试使用
 *
 * @author ZhaoXin
 * @date 2020/6/11 14:35
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
}
