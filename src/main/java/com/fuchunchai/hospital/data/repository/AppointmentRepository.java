package com.fuchunchai.hospital.data.repository;

import com.fuchunchai.hospital.data.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByDate(Date date);
}
