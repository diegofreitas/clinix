package io.clinix.app.repository;



import io.clinix.app.model.Doctor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "Appointment", path = "Appointments")
public interface AppointmentRepository extends PagingAndSortingRepository<Doctor, Long> {

}
