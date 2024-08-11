package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(com.example.demo.annotations.Log)")
    public void logPointcut(){
    }

    @Before("logPointcut()")
    public void logAllMethodCallsAdvice(){
        System.out.println("In Aspect");
    }
    
}
