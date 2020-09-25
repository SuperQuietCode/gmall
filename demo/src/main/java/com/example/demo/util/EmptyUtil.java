package com.example.demo.util;

import java.util.Collection;

/**
 * 判断对象是否为空
 *
 * @author ZhaoXin
 * @date 2020/9/25 14:25
 */
public class EmptyUtil {

    /**
     * 判断字符串是否为空
     * PS:
     * 为空的条件：
     * 1. String对象为空
     * 2. 没有任何字符的字符串
     *
     * @param str 需要判断的字符串
     * @return 为空(true), 非空(false)
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 判断字符串是否为空
     * PS:
     * 为空的条件：
     * 1. String对象为空
     * 2. 没有任何字符的字符串
     *
     * @param str       需要判断的字符串
     * @param isTrimmed 判断前是否去掉字符串前后的空格：是(true), 否(false)
     * @return 为空(true), 非空(false)
     */
    public static boolean isEmpty(String str, boolean isTrimmed) {
        return isTrimmed ? null == str || "".equals(str.trim()) : null == str || "".equals(str);
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 需要进行判断的对象
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * 判断集合是否为空
     * PS：
     * 集合为空的条件：
     * 1. 集合对象为null
     * 2. 集合中没有元素
     *
     * @param collection 需要进行判断的集合
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }

    /**
     * 判断对象数组是否为空
     * PS：
     * 对象数组为空的条件：
     * 1. 对象数组为null
     * 2. 对象数组中没有元素
     *
     * @param array 需要进行判断的对象数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为空
     * PS：
     * 数组为空的条件：
     * 1. 数组为null
     * 2. 数组中没有元素
     *
     * @param array 需要进行判断的数组
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

}
