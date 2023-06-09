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

        Vehicle pVeh = context.getBean(Vehicle.class);
        System.out.println("Primary Bean: " + pVeh.getName());

        Vehicle veh1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("First Vehicle name from Spring Context is: " + veh1.getName());

        Vehicle veh2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Second Vehicle name from Spring Context is: " + veh2.getName());

        Vehicle veh3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Third Vehicle name from Spring Context is: " + veh3.getName());

        Vehicle veh4 = context.getBean("fordVehicle", Vehicle.class);
        System.out.println("Forth Vehicle name from Spring Context is: " + veh4.getName());

        Vehicle veh5 = context.getBean("nissanVehicle", Vehicle.class);
        System.out.println("Fifth Vehicle name from Spring Context is: " + veh5.getName());

        Vehicle veh6 = context.getBean("renaultVehicle", Vehicle.class);
        System.out.println("Sixth Vehicle name from Spring Context is: " + veh6.getName());
    }
}
