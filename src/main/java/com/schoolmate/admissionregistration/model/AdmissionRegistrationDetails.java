package com.schoolmate.admissionregistration.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdmissionRegistrationDetails {
    private Integer registrationId;
    private String studentFirstName;
    private String studentMidName;
    private String studentLastName;
    private String gender;
    private String category;
    private Date dateOfBirth;
    private Address address;
    private ContactDetails contactDetails;
}
