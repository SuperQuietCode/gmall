package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map允许将对象进行转换
 * reduce() 方法将所有数字合成一个  接收多个值并返回一个值
 * Map和Reduce操作是函数式编程的核心操作
 *
 * @author ZhaoXin
 * @date 2020/9/27 14:39
 */
public class LambdaMapDemo {
    public static void main(String[] args) {

        System.out.println("map方法的使用");
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        // 不使用lambda表达式为每个订单加上12%的税
        for (Integer beforeTax : costBeforeTax) {
            double price = beforeTax + 0.12 * beforeTax;
            System.out.println(price);
        }

        System.out.println("-------------------------------");

        List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);
        // 使用lambda表达式为每个订单加上12%的税
        costBeforeTax1.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("reduce方法的使用");
        // 为每个订单加上12%的税
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer integer : costBeforeTax2) {
            double price = integer + .12 * integer;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // reduce方法实现
        List<Integer> costBeforeTax3 = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax3.stream().map(a -> a + a * 0.12).reduce((a, b) -> a + b).get();
        System.out.println("Total : " + bill);

        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(G7Countries);
    }
}
