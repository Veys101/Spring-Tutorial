package com.app.tutorial.springbootschoolwebrestservicewithmvc.service;

import com.app.tutorial.springbootschoolwebrestservicewithmvc.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebrestservicewithmvc.model.Contact;
import com.app.tutorial.springbootschoolwebrestservicewithmvc.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

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
        Contact savedContact = contactRepository.save(contact);
        if(savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findOpenMsgsNative(
                StatusConstants.OPEN, pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
       int rows = contactRepository.updateMsgStatusNative(StatusConstants.CLOSE, contactId);
       return rows > 0;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}
