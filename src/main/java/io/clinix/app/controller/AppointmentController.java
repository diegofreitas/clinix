package io.clinix.app.controller;

import io.clinix.app.repository.AppointmentFormDTO;
import io.clinix.app.repository.AppointmentRepository;
import io.clinix.app.repository.AppointmentItemDTO;
import io.clinix.app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {


    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentService service;

    @GetMapping("/appointments")
    List<AppointmentItemDTO> retrieveAll() {
        return repository.retrieveAll();
    }

    @PostMapping("/appointments")
    private ResponseEntity<Void> createAppointment(@Validated @RequestBody AppointmentFormDTO dto) {
        service.createAppointment(dto);
        return ResponseEntity.ok().build();
    }

}
