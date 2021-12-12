package com.relatime.projects.contactbook.handler;

import com.relatime.projects.contactbook.bindings.ContactFormDTO;

import java.util.List;

public interface ContactService{

    public String saveContact(ContactFormDTO contactFormDTO);

    public List<ContactFormDTO> viewContacts();

    public ContactFormDTO editContact(Integer contactId);

    public List<ContactFormDTO> deleteContact(Integer contactId);
}
