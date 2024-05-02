package com.schoolmate.admissionregistration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GovernmentIdDetails {
    private String govIdType;
    private String govIdNumber;
    private boolean govIdVerified;
}
