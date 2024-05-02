package com.schoolmate.admissionregistration.service;

import com.schoolmate.admissionregistration.model.AdmissionRegistrationDetails;

import java.util.List;

public interface AdmissionRegistrationService {
    public List<AdmissionRegistrationDetails> registerCandidate(List<AdmissionRegistrationDetails> admissionRegistrationDetailsList) throws Exception;
}
