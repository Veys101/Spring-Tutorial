package com.app.tutorial.springbootschoolwebcustomqueryjpa.repository;

import com.app.tutorial.springbootschoolwebcustomqueryjpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
}
