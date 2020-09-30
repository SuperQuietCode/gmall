package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * java.util.function.Predicate 函数式接口是一个非常适用于过滤的接口
 * 可按需要将 Predicate 作为单独条件然后将其合并起来使用
 *
 * @author ZhaoXin
 * @date 2020/9/27 14:24
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J");
        filter(languages, str -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, str -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, str -> true);

        System.out.println("Print no language : ");
        filter(languages, str -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, str -> str.length() > 4);
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter1(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach(name -> System.out.println(name));
    }

}
