package com.app.tutorial.main;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Vehicle;
import com.app.tutorial.config.ProjectConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNum = random.nextInt(10);
        System.out.println("randomNumber = " + randomNum);

        if(randomNum % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volks = null;
        Vehicle audi = null;

        try {
            volks = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Error while creating Volkswagen vehicle");
        }

        try {
            audi = context.getBean("audi", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Error while creating Audi vehicle");
        }

        if (null != volks) {
            System.out.println("Programming Vehicle name from Spring Context is: " + volks.getName());
        } else {
            System.out.println("Programming Vehicle name from Spring Context is: " + audi.getName());
        }


    }
}
