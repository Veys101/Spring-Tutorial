package com.app.tutorial.springbootschoolwebonetomany_manytoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.app.tutorial.springbootschoolwebprofileaddress.repository")
@EntityScan("com.app.tutorial.springbootschoolwebprofileaddress.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SpringbootSchoolMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchoolMvcApplication.class, args);
	}

}
