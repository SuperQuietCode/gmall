package com.example.demo.util;

import java.util.HashMap;

/**
 * 存储本地线程变量
 * @author zhangchongying-JSB
 */
public class LocalVariableUtils {
    private static ThreadLocal<HashMap> localValue = new ThreadLocal<>();

    public static void set(HashMap local) {
        localValue.set(local);
    }

    public static HashMap get() {
        return localValue.get();
    }
}
