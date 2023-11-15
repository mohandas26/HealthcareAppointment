package com.healthcare.HealthcareAppointment.repository;

import com.healthcare.HealthcareAppointment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Override
    Optional<Patient> findById(Long aLong);
}
