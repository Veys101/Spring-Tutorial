package com.app.tutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Person;
import com.app.tutorial.config.ProjectConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println("Person name in Spring Context is: " + person.getName());
        System.out.println("Vehicle that Person owns is: " + person.getVehicle());
        context.close();
    }
}
