package com.fuchunchai.hospital.data.repository;

import com.fuchunchai.hospital.data.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Doctor findByNumber(String number);
}
