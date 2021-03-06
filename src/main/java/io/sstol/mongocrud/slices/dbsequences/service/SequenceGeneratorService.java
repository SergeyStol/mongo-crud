package io.sstol.mongocrud.slices.dbsequences.service;

import io.sstol.mongocrud.slices.dbsequences.db.daos.DatabaseSequenceDao;
import io.sstol.mongocrud.slices.users.db.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
@ConditionalOnMissingBean(ISequenceGeneratorService.class)
public class SequenceGeneratorService implements ISequenceGeneratorService {
    private final MongoOperations mongoOperations;

    public long generateSequence(String seqName) {
        DatabaseSequenceDao counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequenceDao.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}