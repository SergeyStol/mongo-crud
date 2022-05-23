package io.sstol.mongocrud.slices.users.db;

import io.sstol.mongocrud.slices.users.db.daos.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@Repository
public interface UsersRepository extends MongoRepository<UserDao, Long> {

}