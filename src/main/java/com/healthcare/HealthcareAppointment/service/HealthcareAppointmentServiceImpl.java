package com.healthcare.HealthcareAppointment.service;

import com.healthcare.HealthcareAppointment.entity.Appointment;
import com.healthcare.HealthcareAppointment.entity.Patient;
import com.healthcare.HealthcareAppointment.repository.AppointmentRepository;
import com.healthcare.HealthcareAppointment.repository.DoctorRepository;
import com.healthcare.HealthcareAppointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthcareAppointmentServiceImpl {


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public void createAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointments(){
       return appointmentRepository.findAll();
    }

    public int updateAppointment(long id, Appointment newAppointment){
        Appointment appointment =  appointmentRepository.findById(id).get();
        Patient patient = newAppointment.getPatient();

        if(appointmentRepository.findById(newAppointment.getId()).isPresent()){
            System.out.println("Appointment Saved");
            appointmentRepository.save(newAppointment);
            return 1;
        }
        else {
            return 0;
        }
    }

    public int deleteAppointment(long id){

        if (appointmentRepository.findById(id).isPresent()) {
            appointmentRepository.deleteById(id);
            return 1;
        }
        else {
            return 0;
        }
    }

    public  Patient getPatient(long id){
        return patientRepository.findById(id).orElseThrow();
    }
}
