package io.clinix.app.repository;



import io.clinix.app.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {


}
