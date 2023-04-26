package com.app.tutorial.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.app.tutorial.implementation", "com.app.tutorial.services", "com.app.tutorial.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
    
}
