package com.example.demo.test.study;

/**
 * 类中方法执行顺序 -- 面试
 *
 * 调用结果：---静态代码块！--非静态代码块！--默认构造方法！--静态方法中的内容! --静态方法中的代码块！--
 *
 * 非静态代码块与构造函数的区别是：
 *      非静态代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，
 *      因为构造函数是可以多个的，运行哪个构造函数就会建立什么样的对象，但无论建立哪个对象，都会先执行相同的构造代码块。
 *      也就是说，构造代码块中定义的是不同对象共性的初始化内容。
 *
 * @author ZhaoXin
 * @date 2020/8/17 9:32
 */
public class LoadDemo {
    public LoadDemo() {
        System.out.print("默认构造方法--");
    }

    {
        System.out.print("非静态代码块--");
    }

    static {
        System.out.print("静态代码块--");
    }

    public static void load() {
        System.out.print("静态方法中的内容--");
        {
            System.out.print("静态方法中的代码块--");
        }
    }

    public static void main(String[] args) {
        LoadDemo loadDemo = new LoadDemo();
        loadDemo.load();
    }
}
