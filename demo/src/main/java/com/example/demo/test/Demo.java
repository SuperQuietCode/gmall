package com.example.demo.test;

/**
 * @author ZhaoXin
 * @date 2020/7/31 14:20
 */
public class Demo {
    public static void main(String[] args) {
        int one = 100000;
        int end = 0;
        for (int i = 1; i <= 40; i++) {
            end = (int) (one * 0.053);
            one = one + end;
            System.out.println(i + "---" + one + "---" + end);
        }
    }
}
