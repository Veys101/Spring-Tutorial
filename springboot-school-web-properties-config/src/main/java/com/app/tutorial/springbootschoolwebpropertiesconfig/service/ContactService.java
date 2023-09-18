package com.app.tutorial.springbootschoolwebpropertiesconfig.service;

import com.app.tutorial.springbootschoolwebpropertiesconfig.config.SchoolProps;
import com.app.tutorial.springbootschoolwebpropertiesconfig.constants.StatusConstants;
import com.app.tutorial.springbootschoolwebpropertiesconfig.model.Contact;
import com.app.tutorial.springbootschoolwebpropertiesconfig.repository.ContactRepository;
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
    private final SchoolProps schoolProps;
    private int counter = 0;

    @Autowired
    public ContactService(ContactRepository contactRepository, SchoolProps schoolProps) {
        this.contactRepository = contactRepository;
        this.schoolProps = schoolProps;
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

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir) {
        int pageSize = 1;
        if (schoolProps.getContact().get("defaultPageSize") != null) {
            pageSize = Integer.parseInt(schoolProps.getContact().get("defaultPageSize"));
        }
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
