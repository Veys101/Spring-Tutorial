package com.app.tutorial.springbootschoolwebnewuserregistration.service;

import com.app.tutorial.springbootschoolwebnewuserregistration.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebnewuserregistration.model.Person;
import com.app.tutorial.springbootschoolwebnewuserregistration.model.Roles;
import com.app.tutorial.springbootschoolwebnewuserregistration.repository.PersonRepository;
import com.app.tutorial.springbootschoolwebnewuserregistration.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(StatusConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
