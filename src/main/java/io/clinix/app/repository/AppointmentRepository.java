package io.clinix.app.repository;

import io.clinix.app.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query("SELECT " +
            "new io.clinix.app.repository.AppointmentItemDTO(" +
            "a.id,a.doctor.name, a.doctor.speciality, a.patient.name,a.schedule" +
            ") FROM Appointment a order by a.schedule desc")
    List<AppointmentItemDTO> retrieveAll();

}
