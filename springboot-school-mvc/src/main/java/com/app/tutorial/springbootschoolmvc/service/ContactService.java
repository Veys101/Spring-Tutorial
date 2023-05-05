package com.app.tutorial.springbootschoolmvc.service;

import com.app.tutorial.springbootschoolmvc.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public void saveContact(Contact contact) {
        log.info(contact.toString());
    }
}
