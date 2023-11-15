package com.healthcare.HealthcareAppointment.controller;

import com.healthcare.HealthcareAppointment.entity.Appointment;
import com.healthcare.HealthcareAppointment.entity.Patient;
import com.healthcare.HealthcareAppointment.service.HealthcareAppointmentServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class MainController {

    Logger log = Logger.getLogger(MainController.class.getName());
    @Autowired
    HealthcareAppointmentServiceImpl service;

    @PostMapping("/api/appointments")
    public void addAppointment(@RequestBody Appointment appointment){
        log.info("Creating appointment");

         service.createAppointment(appointment);
    }

    @GetMapping("/api/appointments")
    public List<Appointment> getAppointments()  {
        log.info("Getting Appointments for the user");
        return service.getAppointments();
    }
@PutMapping("/api/appointments/{appointmentId}")
    public void updateAppointments(@PathVariable long appointmentId,@RequestBody Appointment newAppointment){
        log.info("Updating Appointments");
        service.updateAppointment(appointmentId,newAppointment);
    }

    @DeleteMapping("/api/appointments/{appointmentId}")
    public void deleteAppointment(@PathVariable long appointmentId){
        log.info("Deleting Appointment");
        service.deleteAppointment(appointmentId);
    }
    @GetMapping("/api/patients/{patientId}")
    public Patient getPatientsInfo(@PathVariable long patientId){
        log.info("Getting Patient records");
        return service.getPatient(patientId);
    }
             
}
