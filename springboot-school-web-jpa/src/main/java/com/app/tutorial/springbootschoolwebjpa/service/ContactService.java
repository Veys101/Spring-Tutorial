package com.app.tutorial.springbootschoolwebjpa.service;

import com.app.tutorial.springbootschoolwebjpa.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebjpa.model.Contact;
import com.app.tutorial.springbootschoolwebjpa.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
//@RequestScope
@SessionScope
//@ApplicationScope
public class ContactService {

    private final ContactRepository contactRepository;
    private int counter = 0;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        System.out.println("Contact service initialized.");
    }

    public boolean saveContact(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(StatusConstants.OPEN);
        contact.setCreatedBy(StatusConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        if(savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findByStatus(StatusConstants.OPEN);
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(StatusConstants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}
