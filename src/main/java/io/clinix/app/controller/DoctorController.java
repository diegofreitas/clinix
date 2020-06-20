package io.clinix.app.controller;

import io.clinix.app.model.Doctor;
import io.clinix.app.model.Patient;
import io.clinix.app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping("/doctors")
    Iterable<Doctor> retrieveAll() {
        return repository.findAll();
    }

    @PostMapping("/doctors")
    ResponseEntity<Void> createPatient(@RequestBody Doctor doctor) {
        repository.save(doctor);
        return ResponseEntity.ok().build();
    }
}
