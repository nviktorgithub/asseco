package hu.asseco.homework.service;

import hu.asseco.homework.exception.UserNotFoundException;
import hu.asseco.homework.model.Role;
import hu.asseco.homework.model.User;
import hu.asseco.homework.model.UserRole;
import hu.asseco.homework.repository.UserRepository;
import hu.asseco.homework.repository.UserRoleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public String login(String username, String password) {
        Optional<User> user = userRepository.login(username, password);
        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            User user1 = user.get();
            user1.setToken(token);
            userRepository.save(user1);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        Optional<User> user = userRepository.findByToken(token);
        if (user.isPresent()) {
            User user1 = user.get();
            org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user2);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<User> getAll() {
        Iterable<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User create(User user, Role role) {
        user.setUserRole(null);
        User ret = userRepository.save(user);
        UserRole userRole = new UserRole(ret, role);
        userRoleRepository.save(userRole);
        return ret;
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Optional<UserRole> userRole = userRoleRepository.findByUser(user.get());
            if (userRole.isPresent()) {
                userRoleRepository.delete(userRole.get());
            }
            userRepository.delete(user.get());
        } else {
            throw new UserNotFoundException();
        }
    }
}