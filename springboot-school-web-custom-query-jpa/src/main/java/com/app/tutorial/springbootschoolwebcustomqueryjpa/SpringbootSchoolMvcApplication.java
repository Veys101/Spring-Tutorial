package com.app.tutorial.springbootschoolwebcustomqueryjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.app.tutorial.springbootschoolwebcustomqueryjpa.repository")
@EntityScan("com.app.tutorial.springbootschoolwebcustomqueryjpa.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SpringbootSchoolMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchoolMvcApplication.class, args);
	}

}