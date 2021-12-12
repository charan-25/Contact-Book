package com.relatime.projects.contactbook.repository;

import com.relatime.projects.contactbook.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {
}
