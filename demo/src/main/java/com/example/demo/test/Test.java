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
    private static final int THREAD_NUM = 30;
    // 请求数量
    private static final int REQUEST_NUM = 1000;
    private CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    @org.junit.Test
    public void fun() {
        Instant start = Instant.now();
        for (int i = 0; i < REQUEST_NUM; i++) {
            System.out.println(i);
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
                        "    \"requestId\": \"111111111\",\n" +
                        "    \"bankCode\": \"ABC\",\n" +
                        "    \"certCode\": \"7935e43ecc4a1cc276bef7dad73dfba922159c671a111488ffa9715050c36efd\",\n" +
                        "    \"userName\": \"ABC\",\n" +
                        "    \"passWord\": \"8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918\"\n" +
                        "}";
                String restJson = HttpUtils.doPost("http://172.20.222.170:8090/caf/server/aHeadQuery",jsonString);
                System.out.println(restJson);

                String json = "{\n" +
                        "    \"requestId\": \"2222222222222222222222\",\n" +
                        "    \"bankCode\": \"ABCJS\",\n" +
                        "    \"certCode\": \"7935e43ecc4a1cc276bef7dad73dfba9c610d6316781abb72a2c7dcfeea2a794\",\n" +
                        "    \"certType\": \"01\",\n" +
                        "    \"productType\": \"01010001\",\n" +
                        "    \"underNum\": \"11\",\n" +
                        "    \"unitMeasure\": \"01\",\n" +
                        "    \"countyLevelCode\": \"320000\",\n" +
                        "    \"years\": \"2021\",\n" +
                        "    \"userName\": \"ABCJS\",\n" +
                        "    \"passWord\": \"8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918\"\n" +
                        "}";
                String rest = HttpUtils.doPost("http://localhost:8090/caf/server/jsFarmerQuery",json);
                System.out.println(rest);
            });
            t.start();
        }
        Instant end = Instant.now();
        System.out.println("执行时间为:" + Duration.between(start, end));
        try {
            // 子线程创建完以后主线程退出，并没有等待子线程作业，所以先等待子线程作业。
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
