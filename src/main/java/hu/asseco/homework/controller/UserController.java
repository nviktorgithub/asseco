package hu.asseco.homework.controller;

import hu.asseco.homework.dto.UserDto;
import hu.asseco.homework.exception.UserNotFoundException;
import hu.asseco.homework.model.Role;
import hu.asseco.homework.model.User;
import hu.asseco.homework.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/user", produces = "application/json")
    public List<UserDto> getAllUser() {
        return StreamSupport.stream(userService.getAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public UserDto getUserDetail(@PathVariable Long id) {
        final User user = Optional.ofNullable(userService.findById(id)).orElseThrow(UserNotFoundException::new);
        return convertToDto(user);
    }

    @PostMapping(value = "/user", produces = "application/json")
    public HttpStatus create(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        userService.create(user, userDto.getRole());
        return HttpStatus.CREATED;
    }

    @DeleteMapping(value = "/user/{id}", produces = "application/json")
    public HttpStatus deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return HttpStatus.OK;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto.setRole(user.getUserRole().getRole());
        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}