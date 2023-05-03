package com.app.tutorial.springbootschoolmvc.service;

import com.app.tutorial.springbootschoolmvc.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public void saveContact(Contact contact) {
        System.out.println(contact.toString());
    }
}
