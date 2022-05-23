package io.sstol.mongocrud.slices.users.service;

import io.sstol.mongocrud.common.exceptions.api.NotFoundException;
import io.sstol.mongocrud.slices.dbsequences.service.SequenceGeneratorService;
import io.sstol.mongocrud.slices.users.api.v1.dtos.UserDto;
import io.sstol.mongocrud.slices.users.db.UsersRepository;
import io.sstol.mongocrud.slices.users.db.daos.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.sstol.mongocrud.slices.users.api.v1.ExceptionMessages.CANT_FIND_USER_WITH_ID;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
    private final UsersRepository repo;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final ModelMapper modelMapper;

    public UserDto getUser(long id) {
        return repo.findById(id)
                .map(this::convertToUserDto)
                .orElseThrow(() -> new NotFoundException(CANT_FIND_USER_WITH_ID + id));
    }

    public List<UserDto> getUsers() {
        return repo.findAll().stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    public long addUser(UserDto userDto) {
        UserDao userDao = convertToUserDao(userDto);
        userDao.setId(sequenceGeneratorService.generateSequence(UserDao.SEQUENCE_NAME));
        userDao = repo.save(userDao);
        long userDaoId = userDao.getId();
        log.debug("Returned user id - {}", userDaoId);
        return userDaoId;
    }

    public void updateUser(UserDto userDto) {
        repo.save(convertToUserDao(userDto));
    }

    public void deleteUser(long id) {
        repo.deleteById(id);
    }

    public UserDto convertToUserDto(UserDao userDao) {
        return modelMapper.map(userDao, UserDto.class);
    }

    public UserDao convertToUserDao(UserDto userDto) {
        return modelMapper.map(userDto, UserDao.class);
    }
}