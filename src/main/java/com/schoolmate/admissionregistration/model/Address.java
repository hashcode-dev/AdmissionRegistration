package com.schoolmate.admissionregistration.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private String houseNumber;
    private String locationDetails;
    private String pinCode;
    private String state;
    private String country;
    private String city;

}
