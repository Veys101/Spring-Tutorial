package com.app.tutorial.springbootschoolwebpropertiesconfig.service;

import com.app.tutorial.springbootschoolwebpropertiesconfig.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Person;
import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Roles;
import com.app.tutorial.springbootschoolwebpropertiesconfig.repository.PersonRepository;
import com.app.tutorial.springbootschoolwebpropertiesconfig.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository,
                         PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(StatusConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
