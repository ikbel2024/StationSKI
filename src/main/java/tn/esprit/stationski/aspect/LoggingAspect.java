package tn.esprit.stationski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @After("execution(* tn.esprit.stationski.services.*.*(..))")
    public void logMethod(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        log.info("ajout effectué avec succes" +name);
    }
}
