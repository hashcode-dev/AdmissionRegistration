package com.schoolmate.admissionregistration.service.impl;

import com.schoolmate.admissionregistration.model.AdmissionRegistrationDetails;
import com.schoolmate.admissionregistration.repository.AdmissionRegistrationRepository;
import com.schoolmate.admissionregistration.service.AdmissionRegistrationService;
import com.schoolmate.admissionregistration.service.SequenceGeneratorService;
import com.schoolmate.admissionregistration.util.ApplicationConstants;
import com.schoolmate.admissionregistration.util.Utility;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("admissionRegistrationService")
@Slf4j
@Getter
public class AdmissionRegistrationServiceImpl implements AdmissionRegistrationService {

    private final AdmissionRegistrationRepository admissionRegistrationRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public AdmissionRegistrationServiceImpl(AdmissionRegistrationRepository admissionRegistrationRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.admissionRegistrationRepository = admissionRegistrationRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public List<AdmissionRegistrationDetails> registerCandidate(List<AdmissionRegistrationDetails> admissionRegistrationDetailsList) {
        try{
            admissionRegistrationDetailsList.forEach(admissionRegistrationDetails -> {
                Long admissionRegistrationId = getSequenceGeneratorService().generateSequence(ApplicationConstants.REGISTRATION_SEQUENCE);
                admissionRegistrationDetails.setId(admissionRegistrationId);
                admissionRegistrationDetails.setRegistrationId(admissionRegistrationId);
                admissionRegistrationDetails.setDateOfRegistration(new Date());
                admissionRegistrationDetails.setCandidateAge(Utility.ageCalculator(admissionRegistrationDetails.getDateOfBirth()));

                admissionRegistrationDetails.getGuardianDetailsList().forEach(guardianDetails -> {
                    guardianDetails.setGuardianAge(Utility.ageCalculator(guardianDetails.getDateOfBirth()));
                });
            });
            return getAdmissionRegistrationRepository().saveAll(admissionRegistrationDetailsList);
        } catch ( Exception e ) {
            log.error("Exception: [{}]", (Object) e.getStackTrace());
        }
        return null;
    }
}
