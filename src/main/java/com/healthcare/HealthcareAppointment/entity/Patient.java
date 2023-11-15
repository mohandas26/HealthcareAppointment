package com.healthcare.HealthcareAppointment.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long patientId;
        private String patientFirstName;
        private String patientLastName;
        @Column(nullable = false, unique = true)
        private String patientContact;


        @OneToOne(mappedBy = "patient")
        private Appointment appointment;

}

