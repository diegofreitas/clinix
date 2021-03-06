package io.clinix.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

@RestController
public class AuthController {

    @Autowired
    private JdbcUserDetailsManager users;

    @Autowired
    private PasswordEncoder enc;
    /**
     * i am using the basic auth(out of the box) i just need to send
     * the username and password in every request, since it does not generate a token
     * or save anything on the session.
     *
     * this endpoint is used in the login form just to implement the login flow.
     * @return
     */
    @GetMapping("/verify-credentials")
    String verifyCredentials() {
        return "{\"status\":\"OK\"}";
    }

    @PostMapping(path="/register-account", consumes = "application/json", produces = "application/json")
    String registerAccount(@RequestBody Credentials credentials) {
        UserDetails details = new org.springframework.security.core.userdetails.User(credentials.getUsername(), enc.encode(credentials.getPassword()), true, true, true, true, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        users.createUser(details);
        return "{\"status\":\"OK\"}";
    }
}
