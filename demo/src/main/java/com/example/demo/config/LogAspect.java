package com.example.demo.config;

import com.example.demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 配置AOP切面日志
 *
 * @author ZhaoXin
 * @date 2020/9/25 10:35
 */
@Slf4j
@Aspect
@Component
@AutoConfigureAfter(RedisUtil.class)
public class LogAspect {

    // 单个情况
    // @Pointcut("execution(public * com.example.demo.test.*.*.*(..))")
    // 多个的情况
    @Pointcut("execution(public * com.example.demo.services.*.*.*(..))")
    public void logPointcut() {

    }

    @Before("logPointcut()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("---------------请求内容---------------");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature().getName());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("---------------请求内容---------------");
    }


    @AfterReturning(returning = "o", pointcut = "logPointcut()")
    public void methodAfterReturning(Object o) {
        log.info("===============返回内容===============");
        log.info("返回的内容:" + o.toString());
        log.info("===============返回内容===============");
    }


    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("***************抛出异常***************");

        log.info("请求类方法:" + joinPoint.getSignature().getName());
        log.info("异常内容:" + e);
        log.info("***************抛出异常***************");
    }

}
