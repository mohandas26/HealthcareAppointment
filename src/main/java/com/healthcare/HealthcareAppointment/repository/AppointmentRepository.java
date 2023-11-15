package com.healthcare.HealthcareAppointment.repository;

import com.healthcare.HealthcareAppointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    //Optional<Appointment> findByApp(String url);
    
    
  //  List<Integer> findIdByFullUrl(String url);
}
