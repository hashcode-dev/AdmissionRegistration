package com.schoolmate.admissionregistration.repository;

import com.schoolmate.admissionregistration.model.AdmissionRegistrationDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdmissionRegistrationRepository extends MongoRepository<AdmissionRegistrationDetails, String> {
}
