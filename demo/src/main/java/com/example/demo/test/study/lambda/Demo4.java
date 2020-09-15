package com.example.demo.test.study.lambda;

import com.example.demo.test.study.lambda.inte.ReturnOneParam;

/**
 * 方法归属者::方法名 静态方法的归属者为类名，普通方法归属者为对象
 *
 * @author ZhaoXin
 * @date 2020/9/15 16:54
 */
public class Demo4 {
    public static void main(String[] args) {
        ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println(lambda1.method(3));

        //lambda2 引用了已经实现的 doubleNum 方法
        ReturnOneParam lambda2 = Demo4::doubleNum;
        System.out.println(lambda2.method(3));

        Demo4 exe = new Demo4();

        //lambda4 引用了已经实现的 addTwo 方法
        ReturnOneParam lambda4 = exe::addTwo;
        System.out.println(lambda4.method(2));
    }

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }
}
