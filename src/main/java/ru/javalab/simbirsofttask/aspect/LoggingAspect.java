package ru.javalab.simbirsofttask.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect{

    /**
     * This aspect logging unchecked exceptions
     *
     * @param e - cought exception
     */

    @AfterThrowing( pointcut = "execution(* ru.javalab.simbirsofttask..*.*(..))",
            throwing = "e")
    public void afterThrowingAdvice(JoinPoint jp, Throwable e){
        log.error("Method Signature: "  + jp.getSignature()+". Exception: "+e);
    }



}
