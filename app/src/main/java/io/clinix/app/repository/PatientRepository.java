package io.clinix.app.repository;



import io.clinix.app.model.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {

    List<Patient> findByName(@Param("name") String name);

}
