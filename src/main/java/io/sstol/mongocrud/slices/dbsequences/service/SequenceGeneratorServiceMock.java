package io.sstol.mongocrud.slices.dbsequences.service;

import io.sstol.mongocrud.slices.dbsequences.db.daos.DatabaseSequenceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Sergey Stol
 * 2022-05-23
 * <a href="https://www.baeldung.com/spring-boot-mongodb-auto-generated-field">https://www.baeldung.com/spring-boot-mongodb-auto-generated-field</a>
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.data.mongodb", name = "mode", havingValue = "mock")
public class SequenceGeneratorServiceMock implements ISequenceGeneratorService {
    public long generateSequence(String seqName) {
        return 1;
    }
}