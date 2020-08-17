package com.example.demo.test.study.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用反射操作TargetObject类中的方法
 *
 * @author ZhaoXin
 * @date 2020/8/17 9:47
 */
public class Main {
    public static void main(String[] args) throws Exception {

        // 获取TargetObject类的Class对象并创建TargetObject类的实例
        Class<?> targetClass = Class.forName("com.example.demo.test.study.reflection.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        // 获取类中所有定义的方法
        // getDeclaredMethods()返回包含一个数组 方法对象反射的类或接口的所有声明的方法，通过此表示 类对象，包括公共，保护，
        // 默认（包）访问和私有方法，但不包括继承的方法。
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        // 获取指定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod",String.class);
        publicMethod.invoke(targetObject, "JavaGuide");

        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "JavaGuide");
        /**
         * 调用 private 方法
         */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
