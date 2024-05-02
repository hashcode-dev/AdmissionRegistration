package com.schoolmate.admissionregistration.controller;

import com.schoolmate.admissionregistration.model.AdmissionRegistrationDetails;
import com.schoolmate.admissionregistration.service.AdmissionRegistrationService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
@Slf4j
@Getter
public class AdmissionRegistrationController {

    private final AdmissionRegistrationService admissionRegistrationService;

    @Autowired
    public AdmissionRegistrationController(AdmissionRegistrationService admissionRegistrationService) {
        this.admissionRegistrationService = admissionRegistrationService;
    }

    @PostMapping("/registerCandidate")
    public List<AdmissionRegistrationDetails> registerCandidate(@RequestBody List<AdmissionRegistrationDetails> admissionRegistrationDetailsList){
        try{
            log.info("Registering the candidate.");
            List<AdmissionRegistrationDetails> registrationDetailsList =  getAdmissionRegistrationService().registerCandidate(admissionRegistrationDetailsList);
            log.info("Candidate registration completed.");
            return registrationDetailsList;
        } catch ( Exception e ) {
            log.debug("Exception: [{}]", (Object) e.getStackTrace());
        }
        return null;
    }

    @GetMapping("/healthCheck")
    public String getHealthStatus(){
        return "Service is up and running.";
    }
}
