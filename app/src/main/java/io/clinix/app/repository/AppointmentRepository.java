package io.clinix.app.repository;

import io.clinix.app.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query("SELECT " +
            "new io.clinix.app.repository.AppointmentVO(" +
            "a.id,a.doctor.name, a.doctor.speciality, a.patient.name,a.schedule" +
            ") FROM Appointment a")
    List<AppointmentVO> retrieveAll();

}
