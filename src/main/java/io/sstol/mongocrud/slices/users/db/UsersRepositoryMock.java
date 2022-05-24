package io.sstol.mongocrud.slices.users.db;

import io.sstol.mongocrud.slices.users.db.daos.UserDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Sergey Stol
 * 2022-05-24
 */
@Repository
@ConditionalOnProperty(prefix = "spring.data.mongodb", name = "mode", havingValue = "mock")
public class UsersRepositoryMock implements UsersRepository {
    @Override
    public <S extends UserDao> S save(S entity) {
        return (S)new UserDao(1, "fN1", "fN2", "Addr");
    }

    @Override
    public <S extends UserDao> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UserDao> findById(Long aLong) {
        return Optional.of(new UserDao(1, "fN1", "fN2", "Addr"));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<UserDao> findAll() {
        return List.of(new UserDao(1, "fN1", "fN2", "Addr"),
                new UserDao(1, "fN1", "fN2", "Addr"));
    }

    @Override
    public Iterable<UserDao> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserDao entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserDao> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserDao> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserDao> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserDao> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends UserDao> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends UserDao> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserDao> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserDao> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserDao> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserDao> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserDao> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UserDao, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
