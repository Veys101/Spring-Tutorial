package com.app.tutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.tutorial.beans.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
        context.close();
    }
}
