package io.clinix.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    /**
     * Since i am using the basic auth(out of the box) i just need to send
     * the username and password in every request since it does not generate a token
     * or save anything on the session.
     *
     * this endpoint is used in the login form just to implement the flow.
     * @return
     */
    @GetMapping("/verify-credentials")
    String verifyCredentials() {
        return "{\"status\":\"OK\"}";
    }
}
