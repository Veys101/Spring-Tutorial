package com.app.tutorial.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {
    
    @Before("execution(* com.app.tutorial.services.*.*(..)) && args(vehicleStarted,..)")
    public void checkVehicleStart(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable {
        if(!vehicleStarted) throw new RuntimeException("Vehicle not started.");
    }
}
