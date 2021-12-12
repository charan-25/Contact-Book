package com.relatime.projects.contactbook.bindings;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactFormDTO {

    private Integer contactId;
    private String contactName;
    private String contactEmail;
    private Long contactNumber;
    private String active;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
