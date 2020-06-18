package io.clinix.app.repository;



import io.clinix.app.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
