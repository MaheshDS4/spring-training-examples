package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLogAspect {
 // pointcut for all methods in DemoService
    @Pointcut("execution(* com.example.aop.DemoService.*(..))")
    public void demoMethods() {}

    @Around("demoMethods()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AOP] Around - before proceed");
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[AOP] Around - after proceed");
        System.out.println("Time taken by function is [{}]" + Long.valueOf(duration));
        return result;
    }
}
