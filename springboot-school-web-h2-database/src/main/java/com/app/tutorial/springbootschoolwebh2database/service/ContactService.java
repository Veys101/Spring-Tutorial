package com.app.tutorial.springbootschoolwebh2database.service;

import com.app.tutorial.springbootschoolwebh2database.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
@SessionScope
//@ApplicationScope
public class ContactService {

    private int counter = 0;

    public ContactService() {
        System.out.println("Contact service initialized.");
    }

    public void saveContact(Contact contact) {
        log.info(contact.toString());
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}
