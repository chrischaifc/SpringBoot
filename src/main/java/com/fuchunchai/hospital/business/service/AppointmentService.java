package com.fuchunchai.hospital.business.service;
import com.fuchunchai.hospital.business.domain.DoctorAppointment;
import com.fuchunchai.hospital.data.entity.Appointment;
import com.fuchunchai.hospital.data.entity.Doctor;
import com.fuchunchai.hospital.data.entity.Patient;
import com.fuchunchai.hospital.data.repository.AppointmentRepository;
import com.fuchunchai.hospital.data.repository.DoctorRepository;
import com.fuchunchai.hospital.data.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//This is the class to return appointment according to date user selected
//Convert stringDate to actual date using simpleDateFormat

@Service
public class AppointmentService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public AppointmentService(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<DoctorAppointment> getDoctorAppointmentForDate(String dateString) {
        Date date = this.createDateFromDateString(dateString);
        Iterable<Doctor> doctors = this.doctorRepository.findAll();
        Map<Long, DoctorAppointment> doctorAppointmentMap = new HashMap<>();
        doctors.forEach(doctor -> {
            DoctorAppointment doctorAppointment = new DoctorAppointment();
            doctorAppointment.setDoctorId(doctor.getId());
            doctorAppointment.setDoctorName(doctor.getName());
            doctorAppointment.setDoctorNumber(doctor.getNumber());
            doctorAppointmentMap.put(doctor.getId(), doctorAppointment);
        });
        Iterable<Appointment> appointments = this.appointmentRepository.findByDate(new java.sql.Date(date.getTime()));
        if (null != appointments){
            appointments.forEach(appointment -> {
                Optional<Patient> patientResponse = this.patientRepository.findById(appointment.getPatient());
                if (patientResponse.isPresent()){
                    Patient patient = patientResponse.get();
                    DoctorAppointment doctorAppointment = doctorAppointmentMap.get(appointment.getId());
                    doctorAppointment.setDate(date);
                    doctorAppointment.setFirstName(patient.getFirstname());
                    doctorAppointment.setLastName(patient.getLasttname());
                    doctorAppointment.setPatientId(patient.getId());
                }
            });
        }
        List<DoctorAppointment> doctorAppointments = new ArrayList<>();
        for (Long doctorId : doctorAppointmentMap.keySet()){
            doctorAppointments.add(doctorAppointmentMap.get(doctorId));
        }
        return doctorAppointments;
    }

    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
