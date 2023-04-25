package com.app.tutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Vehicle;
import com.app.tutorial.config.ProjectConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle1 = context.getBean(Vehicle.class);
        Vehicle vehicle2 = context.getBean("vehicle", Vehicle.class);
        
        System.out.println("Hashcode vehicle1: " + vehicle1.hashCode());
        System.out.println("Hashcode vehicle2: " + vehicle2.hashCode());

        if(vehicle1.hashCode() != vehicle2.hashCode()) {
            System.out.println("Vehicle bean is a prototype scoped bean");
        }
        context.close();
    }
}
