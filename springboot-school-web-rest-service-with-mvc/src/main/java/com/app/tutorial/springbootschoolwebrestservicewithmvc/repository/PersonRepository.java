package com.app.tutorial.springbootschoolwebrestservicewithmvc.repository;

import com.app.tutorial.springbootschoolwebrestservicewithmvc.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
}
