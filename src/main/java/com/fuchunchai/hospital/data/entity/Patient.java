package com.fuchunchai.hospital.data.entity;

import javax.persistence.*;

//Entity class for Patient

@Entity
@Table(name="PATIENT")
public class Patient {
    @Id
    @Column(name="PATIENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="FIRST_NAME")
    private String firstname;
    @Column(name="LAST_NAME")
    private String lasttname;
    @Column(name="EMAIL_ADDRESS")
    private String email;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="CITY")
    private String city;
    @Column(name="PHONE_NUMBER")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
