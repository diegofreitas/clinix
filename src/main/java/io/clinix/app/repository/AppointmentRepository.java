package io.clinix.app.repository;

import io.clinix.app.model.Appointment;
import io.clinix.app.model.Doctor;
import io.clinix.app.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query("SELECT " +
            "new io.clinix.app.repository.AppointmentItemDTO(" +
            "a.id,a.doctor.name, a.doctor.speciality, a.patient.name,a.schedule" +
            ") FROM Appointment a order by a.schedule desc")
    List<AppointmentItemDTO> retrieveAll();

    List<Appointment> findAppointmentsByScheduleBetweenAndDoctor(LocalDateTime start, LocalDateTime end, Doctor d);
    List<Appointment> findAppointmentsByScheduleBetweenAndPatient(LocalDateTime start, LocalDateTime end, Patient p);





}
