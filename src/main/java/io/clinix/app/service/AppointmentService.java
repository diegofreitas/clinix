package io.clinix.app.service;

import io.clinix.app.model.Appointment;
import io.clinix.app.model.Doctor;
import io.clinix.app.model.Patient;
import io.clinix.app.repository.AppointmentFormDTO;
import io.clinix.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public void createAppointment(AppointmentFormDTO dto) {

        Doctor doctor = Doctor.builder().id(dto.getDoctorId()).build();
        Patient patient = Patient.builder().id(dto.getPatientId()).build();
        List<Appointment> doctorAppointments = appointmentRepository.findAppointmentsByScheduleBetweenAndDoctor(
                dto.getSchedule().minusMinutes(59).minusSeconds(59), dto.getSchedule().plusMinutes(59).plusSeconds(59), doctor
        );
        if(!doctorAppointments.isEmpty()) {
            throw new IllegalStateException("Conflinting appointment");
        }

        List<Appointment> patientsAppointment = appointmentRepository.findAppointmentsByScheduleBetweenAndPatient(
                dto.getSchedule().minusMinutes(59).minusSeconds(59), dto.getSchedule().plusMinutes(59).plusSeconds(59), patient
        );
        if(!patientsAppointment.isEmpty()) {
            throw new IllegalStateException("Conflinting appointment");
        }
        appointmentRepository.save(Appointment.builder()
                .doctor(doctor)
                .patient(patient)
                .schedule(dto.getSchedule()).build());
    }
}
