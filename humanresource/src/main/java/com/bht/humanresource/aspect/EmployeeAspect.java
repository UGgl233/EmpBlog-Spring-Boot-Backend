package com.bht.humanresource.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

    @Pointcut("execution( * com.bht.humanresource.controller.EmployeeController.*(..))")
    public void testLog(){}

    @AfterThrowing("testLog()")
    public void throwing(JoinPoint jp) {
        System.out.println("Got a error");
    }

//    @After("testLog()")
//    public void emm(){
//        System.out.println("after it");
//    }
}
