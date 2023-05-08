package com.app.tutorial.springbootschoolbackendvalidation.service;

import com.app.tutorial.springbootschoolbackendvalidation.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public void saveContact(Contact contact) {
        log.info(contact.toString());
    }
}
