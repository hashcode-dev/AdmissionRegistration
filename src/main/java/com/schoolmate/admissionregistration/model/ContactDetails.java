package com.schoolmate.admissionregistration.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactDetails {
    private String primaryContact;
    private String secondaryContact;
    private String email;
    private Boolean primaryContactOnWA;
}
