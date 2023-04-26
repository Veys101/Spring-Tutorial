package com.app.tutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.tutorial.config.ProjectConfig;
import com.app.tutorial.model.Song;
import com.app.tutorial.services.PersonService;
import com.app.tutorial.services.VehicleService;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        System.out.println(vehicleService.getClass());
        Song song = new Song();
        song.setTitle("Blank Space");
        song.setSingerName("Taylor Swift");
        boolean vehicleStarted = true;
        vehicleService.moveVehicle(vehicleStarted);
        vehicleService.playMusic(vehicleStarted,song);
        vehicleService.applyBrake(vehicleStarted);

        PersonService personService = context.getBean(PersonService.class);
        personService.setName("John");
        personService.printPerson();
        context.close();
    }
}
