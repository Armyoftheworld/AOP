package com.army.aop;

import com.army.aop.annotation.BehaviorTrace;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Date;
import java.util.Locale;

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/10/20
 * @description
 */
@Aspect
public class BehaviorAspect {

    /**
     * 找到任何持有BehaviorTrace注解的方法
     */
    @Pointcut("execution(@com.army.aop.annotation.BehaviorTrace * *(..))")
    public void annoBehavior() {
    }

    /**
     * 添加额外的操作
     */
    @Around("annoBehavior()")
    public Object dealBehaviorPoint(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        BehaviorTrace annotation = signature.getMethod().getAnnotation(BehaviorTrace.class);
        String value = annotation.value();
        Date start = new Date();
        System.out.println(String.format(Locale.getDefault(), "%s start = %d", value, start.getTime()));
        Object result = point.proceed();
        Date end = new Date();
        System.out.println(String.format(Locale.getDefault(), "%s start = %d", value, end.getTime()));
        System.out.println(String.format(Locale.getDefault(), "total = %d", end.getTime() - start.getTime()));
        return result;
    }
}