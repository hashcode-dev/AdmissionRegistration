package com.schoolmate.admissionregistration.repository;

import com.schoolmate.admissionregistration.model.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<Sequence, String> {
}
