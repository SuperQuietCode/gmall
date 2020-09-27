package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * lambda练习
 *
 * @author ZhaoXin
 * @date 2020/9/27 13:51
 */
public class Test {
    public static void main(String[] args) {

        // 多行语句的时候可以使用花括号分割
        Arrays.asList("1", "2", "3", "4").forEach(s -> {
            if ("2".equals(s)) {
                System.out.println(true);
            }
        });

        // lambda表达式会引用类成员和局部变量
        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String s) -> System.out.println(s + separator));

        // 如果lambda表达式中只有一行则可以不适用return语句
        Arrays.asList("a", "b", "d").sort(String::compareTo);
        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        // 要找到所有以J开始，长度为四个字母的名字
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLone = (n) -> n.length() == 4;
        languages.stream().filter(startWithJ.and(fourLetterLone))
                .forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));

    }
}
