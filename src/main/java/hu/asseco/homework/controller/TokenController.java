package hu.asseco.homework.controller;

import hu.asseco.homework.exception.AuthenticationFailureException;
import hu.asseco.homework.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/authentication", consumes = "application/json", produces = "application/json")
    public Token getToken(@RequestBody AuthUser authUser) {
        String token = userService.login(authUser.getUsername(), authUser.getPassword());
        if (StringUtils.isEmpty(token)) {
            throw new AuthenticationFailureException();
        }
        return new Token(token);
    }

    private static class AuthUser {
        private String username;
        private String password;

        public AuthUser() {
        }

        public AuthUser(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private static class Token {
        private String token;

        public Token() {
        }

        public Token(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}