package com.example.demo.test;

/**
 * 并发测试
 *
 * @author ZhaoXin
 * @date 2020/8/7 11:05
 */

import com.example.demo.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
public class Test {
    //并发数量
    private static final int THREAD_NUM = 10000;
    private CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    @org.junit.Test
    public void fun() {
        Instant start = Instant.now();
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
                String jsonString = "{\n" +
                        "                    \"organizationCName\":\"中文名2\",\n" +
                        "                        \"unifiedSocialCreditCode\":\"\",\n" +
                        "                        \"organizationNo\":\"\",\n" +
                        "                        \"taxRegistNo\":\"\",\n" +
                        "                        \"busiLicenseCode\":\"\",\n" +
                        "                        \"userName\":\"BJ2020001\",\n" +
                        "                        \"passWord\":\"123456\"\n" +
                        "                }";
                String restJson = HttpUtils.doPost("http://localhost:8080/caf/server/mechanismSingleQuery",jsonString);
                System.out.println(restJson);
            });
            t.start();
        }
        Instant end = Instant.now();
        System.out.println("执行时间为:" + Duration.between(start, end));
        try {
            // 子线程创建完以后主线程退出，并没有等待子线程作业，所以先等待子线程作业。
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
