package com.schoolmate.admissionregistration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContactDetails {
    private String primaryContact;
    private String secondaryContact;
    private String email;
    private Boolean primaryContactOnWA;
}
