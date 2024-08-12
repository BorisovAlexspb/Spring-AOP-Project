package com.example.demo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.example.demo.annotations.Exception)")
    public void exceptionPointcut() {
    }

    @Pointcut("execution(* com.example.demo.service.jpa.*.get*(..))")
    public void logPointcutServicesForGetMethod() {
    }

    @Pointcut("execution(* com.example.demo.service.jpa.*.delete*(..))")
    public void logPointcutServicesForDeleteMethod() {
    }

    @Pointcut("execution(* com.example.demo.service.jpa.*.create*(..))")
    public void logPointcutServicesForCreateMethod() {
    }


    @Before("logPointcutServicesForGetMethod()")
    public void logMethodCallsWithinAdviceForGetMethod(JoinPoint joinPoint) {
        logger.info("Get method <<{}>> is running", joinPoint.getSignature().getName());
    }

    @Before("logPointcutServicesForDeleteMethod()")
    public void logMethodCallsWithinAdviceForDeleteMethod(JoinPoint joinPoint) {
        logger.info("Delete method <<{}>> is running", joinPoint.getSignature().getName());
    }

    @Before("logPointcutServicesForCreateMethod()")
    public void logMethodCallsWithinAdviceForCreateMethod(JoinPoint joinPoint) {
        logger.info("Create method <<{}>> is running", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "exceptionPointcut()", throwing = "ex")
    public void logMethodThrowingException(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exception in {} method () - {}", methodName, ex.getMessage());
    }

}
