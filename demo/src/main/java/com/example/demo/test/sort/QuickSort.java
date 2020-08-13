package com.example.demo.test.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * 快速排序
 *
 * @author ZhaoXin
 * @date 2020/8/11 14:32
 */
public class QuickSort {
    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length -1){
                System.out.print(arr[i] + ",");
            }else {
                System.out.println(arr[i] + "]");
            }
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp 是基准位
        temp = arr[low];

        while (i < j) {
            // 先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // 再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // 如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        // 最后将基准为i和j相等位置的数字交换位置
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}
