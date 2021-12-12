package com.relatime.projects.contactbook.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="CONTACT_DTLS")
@Data
public class Contact {

    @Id
    @Column(name="CONTACT_ID")
    @GeneratedValue
    private Integer contactId;

    @Column(name="CONTACT_NAME")
    private String contactName;

    @Column(name="CONTACT_EMAIL")
    private String contactEmail;

    @Column(name="CONTACT_NUMBER")
    private Long contactNumber;

    @Column(name="ACTIVE")
    private String active;

    @Column(name="CREATED_DATE")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="UPDATED_DATE")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
