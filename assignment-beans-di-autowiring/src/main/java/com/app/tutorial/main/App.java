package com.app.tutorial.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Vehicle;
import com.app.tutorial.config.ProjectConfig;
import com.app.tutorial.interfaces.Tyres;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        String tyres[] = context.getBeanNamesForType(Tyres.class);
        Arrays.stream(tyres).forEach(System.out::println);
        System.out.println();
        vehicle.move();
        vehicle.playMusic();
        context.close();
    }
}
