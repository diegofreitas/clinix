package io.clinix.app.controller;

import io.clinix.app.model.Patient;
import io.clinix.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping("/patients")
    Iterable<Patient> retrieveAll() {
        return repository.findAll();
    }


}
