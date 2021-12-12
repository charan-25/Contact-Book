package com.relatime.projects.contactbook.rest;

import com.relatime.projects.contactbook.bindings.ContactFormDTO;
import com.relatime.projects.contactbook.handler.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    private ContactService contactService;
    private Logger logger = LoggerFactory.getLogger(ContactRestController.class);
    private final String className = this.getClass().getSimpleName();

    @PostMapping("/save-contact")
    public String saveContact(@RequestBody ContactFormDTO contactFormDTO){
        logger.info("Entering :: "+className+" :: saveContact() Method");
        return contactService.saveContact(contactFormDTO);
    }

    @GetMapping("/get-all-contacts")
    public List<ContactFormDTO> viewContacts(){
        logger.info("Entering :: "+className+" :: viewContacts() Method");
        return contactService.viewContacts();
    }

    @GetMapping("/edit-contact/{contactId}")
    public ContactFormDTO editContact(@PathVariable("contactId") Integer contactId){
        logger.info("Entering :: "+className+" :: editContact() Method");
        return contactService.editContact(contactId);
    }

    @DeleteMapping("/delete-contact/{contactId}")
    public List<ContactFormDTO> deleteContact(@PathVariable("contactId") Integer contactId){
        logger.info("Entering :: "+className+" :: deleteContact() Method");
        return contactService.deleteContact(contactId);
    }
}
