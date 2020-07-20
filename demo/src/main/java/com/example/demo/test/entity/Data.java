package com.example.demo.test.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 添加的测试数据类
 *
 * @author ZhaoXin
 * @date 2020/7/20 15:51
 */
public class Data {

    private static List<PersonModel> list = null;

    static {
        PersonModel wu = new PersonModel("wu qi", 18, "男");
        PersonModel zhang = new PersonModel("zhang san", 19, "男");
        PersonModel wang = new PersonModel("wang si", 20, "女");
        PersonModel zhao = new PersonModel("zhao wu", 20, "男");
        PersonModel chen = new PersonModel("chen liu", 21, "男");
        list = Arrays.asList(wu, zhang, wang, zhao, chen);
    }

    public static List<PersonModel> getData(){
        return list;
    }
}
