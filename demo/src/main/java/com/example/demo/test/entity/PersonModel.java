package com.example.demo.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PersonModel测试类
 *
 * @author ZhaoXin
 * @date 2020/7/20 15:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel implements Comparable {
    private String name;
    private Integer age;
    private String gender;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
