package com.app.tutorial.springbootschoolwebh2database.service;

import com.app.tutorial.springbootschoolwebh2database.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebh2database.model.Contact;
import com.app.tutorial.springbootschoolwebh2database.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

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
        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(StatusConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,StatusConstants.CLOSE, updatedBy);
        if(result>0) {
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
