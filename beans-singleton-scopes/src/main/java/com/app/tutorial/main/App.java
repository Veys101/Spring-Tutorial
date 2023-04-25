package com.app.tutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.beans.Person;
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

        if(vehicle1.hashCode() == vehicle2.hashCode()) {
            System.out.println("Vehicle bean is a singleton scoped bean");
        }
        
        System.out.println();

        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean("person", Person.class);

        System.out.println("Hashcode person1: " + person1.hashCode());
        System.out.println("Hashcode person2: " + person2.hashCode());

        if(person1.hashCode() == person2.hashCode()) {
            System.out.println("Person bean is a singleton scoped bean");
        }

        context.close();
    }
}
