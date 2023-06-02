package com.app.tutorial.springbootschoolwebnewuserregistration.service;

import com.app.tutorial.springbootschoolwebnewuserregistration.model.Person;
import com.app.tutorial.springbootschoolwebnewuserregistration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        person = personRepository.save(person);
        if (person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
