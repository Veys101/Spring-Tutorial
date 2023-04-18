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
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Component Vehicle Name from Spring Context is: " + veh.getName());
        veh.printVehicle();
        
        veh.setName("Fiat");
        System.out.println("Component Vehicle Name from Spring Context is: " + veh.getName());

        context.close();
    }
}
