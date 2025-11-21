package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // pointcut for all methods in DemoService
    @Pointcut("execution(* com.example.aop.DemoService.*(..))")
    public void demoMethods() {}

    @Before("demoMethods()")
    public void beforeAdvice() {
        System.out.println("[AOP] Before advice executed");
    }

    @After("demoMethods()")
    public void afterAdvice() {
        System.out.println("[AOP] After advice executed");
    }

    @Around("demoMethods()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AOP] Around - before proceed");
        Object result = pjp.proceed();
        System.out.println("[AOP] Around - after proceed");
        return result;
    }

    @AfterReturning(pointcut = "demoMethods()", returning = "ret")
    public void afterReturningAdvice(Object ret) {
        System.out.println("[AOP] After returning advice. Return value: " + ret);
    }

    @AfterThrowing(pointcut = "demoMethods()", throwing = "ex")
    public void afterThrowingAdvice(Throwable ex) {
        System.out.println("[AOP] After throwing advice. Exception: " + ex.getMessage());
    }
}
