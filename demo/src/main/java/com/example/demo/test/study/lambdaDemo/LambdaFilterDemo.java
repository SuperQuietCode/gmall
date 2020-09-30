package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter案例
 *  -- 暂时没感觉到作用
 *
 * @author ZhaoXin
 * @date 2020/9/27 14:54
 */
public class LambdaFilterDemo {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
}
