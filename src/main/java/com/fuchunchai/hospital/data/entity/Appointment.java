package com.fuchunchai.hospital.data.entity;

import javax.persistence.*;
import java.util.Date;

//Entity class for appointment

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @Column(name = "APPOINTMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "DOCTOR_ID")
    private long doctor;
    @Column(name = "PATIENT_ID")
    private long patient;
    @Column(name = "APP_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctor() {
        return doctor;
    }

    public void setDoctor(long doctor) {
        this.doctor = doctor;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
