package com.example.demo.test.study.reflection;

/**
 * 反射机制
 *
 * @author ZhaoXin
 * @date 2020/8/17 9:44
 */
public class TargetObject {

    private String value;

    // 构造方法初始化对象
    public TargetObject() {
        value = "java";
    }

    // public
    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    // private
    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
