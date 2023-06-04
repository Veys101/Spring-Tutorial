package com.app.tutorial.springbootschoolwebcustomauthentication.repository;

import com.app.tutorial.springbootschoolwebcustomauthentication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
}
