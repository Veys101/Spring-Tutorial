package com.app.tutorial.springbootschoolwebnewuserregistration.repository;

import com.app.tutorial.springbootschoolwebnewuserregistration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {}
