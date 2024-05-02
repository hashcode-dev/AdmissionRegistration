package com.schoolmate.admissionregistration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GuardianDetails {
    private String guardianFirstName;
    private String guardianMidName;
    private String guardianLastName;
    private String gender;
    private String relation;
    private String category;
    private Date dateOfBirth;
    private Integer guardianAge;
    private Address residenceAddress;
    private ContactDetails contactDetails;
    private GovernmentIdDetails governmentIdDetails;
}
