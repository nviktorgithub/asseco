package hu.asseco.homework.service;

import hu.asseco.homework.model.Role;
import hu.asseco.homework.model.User;

import java.util.Optional;

public interface UserService {

    String login(String username, String password);

    Optional<org.springframework.security.core.userdetails.User> findByToken(String token);

    Iterable<User> getAll();

    User findById(Long id);

    User create(User user, Role role);

    void delete(Long id);
}