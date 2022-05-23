package io.sstol.mongocrud.slices.users.api.v1;

import io.sstol.mongocrud.slices.users.api.v1.dtos.UserDto;
import io.sstol.mongocrud.slices.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sergey Stol
 * 2022-05-23
 */
@RestController
@RequestMapping("/v1" + "/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;

    // GET /v1/users/:id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable long id) {
        return service.getUser(id);
    }

    // GET /v1/users
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        return service.getUsers();
    }

    // POST /v1/users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long addUser(@RequestBody UserDto userDto) {
        return service.addUser(userDto);
    }

    // PUT /v1/users
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody UserDto userDto) {
        service.updateUser(userDto);
    }

    // DELETE /v1/users/:id
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        service.deleteUser(id);
    }
}