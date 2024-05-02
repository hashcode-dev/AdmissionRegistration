package com.schoolmate.admissionregistration.service.impl;

import com.schoolmate.admissionregistration.model.Sequence;
import com.schoolmate.admissionregistration.service.SequenceGeneratorService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service("sequenceGeneratorService")
@Slf4j
@Getter
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

    private final MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Long generateSequence(String seqName) {
        try{
            log.info("Generating MongoDB sequence.");
            Sequence sequence = getMongoOperations().findAndModify(
                    query(where("_id").is(seqName)),
                    new Update().inc("seq", 1),
                    options().returnNew(true).upsert(true),
                    Sequence.class);
            Long sequenceId = sequence.getSeq();
            log.info("Generated MongoDB sequence: [{}]", sequenceId);
            return sequenceId;
        }catch ( Exception e ) {
            log.debug("Exception: [{}]", (Object) e.getStackTrace());
        }
        return null;
    }
}
