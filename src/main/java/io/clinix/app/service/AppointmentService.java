package io.clinix.app.service;

import io.clinix.app.model.Appointment;
import io.clinix.app.model.Doctor;
import io.clinix.app.model.Patient;
import io.clinix.app.repository.AppointmentFormDTO;
import io.clinix.app.repository.AppointmentRepository;
import io.clinix.app.repository.DoctorRepository;
import io.clinix.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public void createAppointment(AppointmentFormDTO dto) {
        Appointment appointment = new Appointment();
        Doctor doctor = Doctor.builder().id(dto.getDoctorId()).build();
        Patient patient = Patient.builder().id(dto.getPatientId()).build();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
    }
}
