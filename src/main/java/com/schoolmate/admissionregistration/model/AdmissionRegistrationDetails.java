package com.schoolmate.admissionregistration.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document("admission_registration")
public class AdmissionRegistrationDetails {
    @Id
    private Long registrationId;
    private String studentFirstName;
    private String studentMidName;
    private String studentLastName;
    private String gender;
    private String category;
    private Date dateOfBirth;
    private Date dateOfRegistration;
    private Integer candidateAge;
    private Address communicationAddress;
    private List<GuardianDetails> guardianDetailsList;
}
