package com.example.demo.test.study.lambdaDemo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。
 * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistics，
 * 描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。
 * 它也有 getSum() 和 getAverage()法来获得列表的所有元素的总和及平均值。
 *
 * @author ZhaoXin
 * @date 2020/9/27 15:10
 */
public class IntSummaryStatisticsDemo {
    public static void main(String[] args) {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
