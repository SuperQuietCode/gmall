package com.example.demo.test.study.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式
 *
 * ArrayList排序
 * @author ZhaoXin
 * @date 2020/9/15 15:05
 */
public class Demo1 {
    public static void main(String[] args) {
        List list = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list);
        Collections.sort(list, (String a, String b)->{
            return a.compareTo(b);
        });
        System.out.println(list);

        Collections.sort(list, (String a, String b)->b.compareTo(a));
        System.out.println(list);

        Collections.sort(list, String::compareTo);
        System.out.println(list);

    }
}
