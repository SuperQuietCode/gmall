package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复制不同的值，创建一个子列表
 * 本例展示了如何利用流的 distinct() 方法来对集合进行去重。
 *
 * @author ZhaoXin
 * @date 2020/9/27 15:01
 */
public class LambdaDistinctDemo {
    public static void main(String[] args) {
        // 去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
}
