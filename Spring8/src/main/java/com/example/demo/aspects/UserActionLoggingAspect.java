package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionLoggingAspect {
    @Before("@annotation(TrackUserAction)")
    public void logUserAction(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String className = signature.getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Метод вызван " + className + "." + methodName + " с аргументами:");
        for(Object object : args) {
            System.out.println(object);
        }
    }
}