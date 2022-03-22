package com.example.demo.test;

import com.example.demo.test.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射遍历对象
 *
 * @author ZhaoXin
 * @date 2021-12-1 14:25
 */
public class ClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        get();
    }

    public static void get() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student st = new Student("张三", 10);
        Field[] fields = Student.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            String methName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method m = st.getClass().getMethod("get" + methName);
            Object value = m.invoke(st);
            System.out.println(value.toString());
        }
    }
}
