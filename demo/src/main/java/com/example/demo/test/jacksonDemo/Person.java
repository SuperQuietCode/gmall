package com.example.demo.test.jacksonDemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhaoXin
 * @date 2020/9/30 11:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
// 序列化@JsonIgnoreProperties与@JsonIgnore类似，用于类上，注解使用的是字段别名
// @JsonIgnoreProperties(value={"name","age"})
public class Person {

    // @JsonIgnore注解是在序列化时忽略该字段
    // @JsonProperty注解类似于sql里字段的别名，用于序列化，使用注解字段属性，替代原字段属性

    // @JsonProperty
    // 当Json的属性值和Java的属性值不一样时，会映射失败，用这个注解指定映射关系，
    // 在属性上用这个注解，则序列化和反序列化都会用这个值。如果序列化和反序列化的属性不一致，
    // 可以在get方法或者set方法上用这个注解，set方法影响反序列化，get方法影响序列化。
    @JsonProperty("userName")
    // @JsonIgnore
    private String name;

    private Integer age;
}
