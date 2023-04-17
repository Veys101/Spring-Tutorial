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
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + hello);
        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is: " + num);

    }
}
