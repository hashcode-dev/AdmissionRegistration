package com.schoolmate.admissionregistration.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AdmissionRegistrationAspect {

    @Pointcut("within(com.schoolmate.admissionregistration.controller..*)")
    public void controllerPointCut(){
    }

    @Pointcut("execution(* com.schoolmate.admissionregistration.controller.*.*(..))")
    public void calculateExecutionTime(){
    }

    @Before("controllerPointCut()")
    public void loggingMethod(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        try{
            log.info("Method: [{}]", methodSignature.getName());
        }catch (Exception e){
            log.debug("Exception: [{}]", e.getMessage());
        }
    }

    @Around("calculateExecutionTime()")
    public Object findExecutionTime(ProceedingJoinPoint pjp) {
        try{
            long startTime = System.currentTimeMillis();
            log.info("Going to call method: [{}]", pjp.getSignature().getName());
            Object obj = pjp.proceed();
            log.info("Method Execution completed: [{}]", pjp.getSignature().getName());
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("Method Execution time in ms: [{}]", elapsedTime);
            return obj;
        }catch (Throwable e){
            log.info("Exception: [{}]", e.getMessage());
        }
        return null;
    }
}
