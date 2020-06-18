package io.clinix.app.controller;

import io.clinix.app.model.Appointment;
import io.clinix.app.repository.AppointmentRepository;
import io.clinix.app.repository.AppointmentVO;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class AppointmentController {


    @Autowired
    private AppointmentRepository repository;

    @GetMapping("/appointments")
    List<AppointmentVO> retrieveAll() {
        return repository.retrieveAll();
    }

}
