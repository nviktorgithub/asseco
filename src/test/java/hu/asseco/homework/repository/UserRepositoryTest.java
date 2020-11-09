package hu.asseco.homework.repository;

import hu.asseco.homework.HomeworkApplication;
import hu.asseco.homework.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = HomeworkApplication.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void login() {
        final String username = "username";
        final String password = "password";
        User user1 = userRepository.save(new User(username, password, "foo","bar"));
        Optional<User> user2 = userRepository.login(username, password);
        assertTrue(user2.isPresent());
        assertEquals(user1, user2.get());
    }
}