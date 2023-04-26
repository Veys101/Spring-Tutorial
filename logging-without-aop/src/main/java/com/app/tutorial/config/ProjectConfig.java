package com.app.tutorial.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.app.tutorial.implementation", "com.app.tutorial.services"})
public class ProjectConfig {
    
}
