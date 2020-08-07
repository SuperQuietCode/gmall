package com.example.demo.test;

/**
 * @author ZhaoXin
 * @date 2020/8/7 11:05
 */

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
    //并发数量
    private static final int THREAD_NUM = 10000;
    private CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    @org.junit.Test
    public void fun() {
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread t = new Thread(() -> {
                try {
                    // 减一
                    cdl.countDown();
                    // 等待
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 并发执行(这里写业务。)

                System.out.println("并发执行。");
            });
            t.start();
        }
        try {
            // 子线程创建完以后主线程退出，并没有等待子线程作业，所以先等待子线程作业。
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
