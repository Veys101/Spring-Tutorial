package com.app.tutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Vehicle;
import com.app.tutorial.config.ProjectConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Vehicle veh = context.getBean(Vehicle.class);
        Vehicle veh1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("First Vehicle name from Spring Context is: " + veh1.getName());

        Vehicle veh2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Second Vehicle name from Spring Context is: " + veh2.getName());

        Vehicle veh3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Third Vehicle name from Spring Context is: " + veh3.getName());

        Vehicle veh4 = context.getBean("fordVehicle", Vehicle.class);
        System.out.println("Forth Vehicle name from Spring Context is: " + veh4.getName());
    }
}
