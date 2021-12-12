package com.relatime.projects.contactbook.handlerImpl;

import com.relatime.projects.contactbook.bindings.ContactFormDTO;
import com.relatime.projects.contactbook.entities.Contact;
import com.relatime.projects.contactbook.handler.ContactService;
import com.relatime.projects.contactbook.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepo;

    private Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    private final String className = this.getClass().getSimpleName();


    @Override
    public String saveContact(ContactFormDTO contactFormDTO) {
        logger.info("Entering :: "+className+" :: saveContact() Method");
        Contact contact =new Contact();
        BeanUtils.copyProperties(contactFormDTO,contact);
        contact.setActive("Y");
        contact = contactRepo.save(contact);
        if(contact.getContactId()!=null) {
            logger.info("Exiting :: "+className+" :: saveContact() Method");
            return "SUCCESS";
        }
        logger.info("Exiting :: "+className+" :: saveContact() Method");
        return "FAILURE";
    }

    @Override
    public List<ContactFormDTO> viewContacts() {
        logger.info("Entering :: "+className+" :: viewContacts() Method");

        List<Contact> entities = contactRepo.findAll();
        List<ContactFormDTO> contactList = new ArrayList<>();
        for(Contact contact: entities){
            ContactFormDTO contacts = new ContactFormDTO();
            BeanUtils.copyProperties(contact,contacts);
            contactList.add(contacts);
        }
        logger.info("Exiting :: "+className+" :: viewContacts() Method");
        return contactList;
    }

    @Override
    public ContactFormDTO editContact(Integer contactId) {
        logger.info("Entering :: "+className+" :: editContact() Method");
        ContactFormDTO contactForm = new ContactFormDTO();
        Optional<Contact> entity = contactRepo.findById(contactId);
        if(entity.isPresent()){
            Contact contact = entity.get();
            BeanUtils.copyProperties(contact,contactForm);
        }
        logger.info("Exiting :: "+className+" :: editContact() Method");
        return contactForm;
    }

    @Override
    public List<ContactFormDTO> deleteContact(Integer contactId) {
        logger.info("Entering :: "+className+" :: deleteContact() Method");
        contactRepo.deleteById(contactId);
        return viewContacts();
    }
}
