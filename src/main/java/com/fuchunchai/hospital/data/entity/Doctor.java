package com.fuchunchai.hospital.data.entity;

import javax.persistence.*;

//Entity class for Doctor

@Entity
@Table(name="DOCTOR")
public class Doctor {
    @Id
    @Column(name="DOCTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="DOCTOR_NUMBER")
    private String number;
    @Column(name="DOCTOR_INFO")
    private String doctorInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}
