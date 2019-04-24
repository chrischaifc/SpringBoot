package com.fuchunchai.hospital.data.repository;

import com.fuchunchai.hospital.data.entity.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {
}
