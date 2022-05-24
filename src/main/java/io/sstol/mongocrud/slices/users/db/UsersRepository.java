package io.sstol.mongocrud.slices.users.db;

import io.sstol.mongocrud.slices.users.db.daos.UserDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@Repository
@ConditionalOnMissingBean(UsersRepository.class)
public interface UsersRepository extends MongoRepository<UserDao, Long> {

}