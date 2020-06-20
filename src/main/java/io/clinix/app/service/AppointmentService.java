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

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public void createAppointment(AppointmentFormDTO dto) {
        Doctor doctor = Doctor.builder().id(dto.getDoctorId()).build();
        Patient patient = Patient.builder().id(dto.getPatientId()).build();
        appointmentRepository.save(Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .schedule(dto.getSchedule()).build());
    }
}
