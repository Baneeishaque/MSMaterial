package com.hospital.repository;

import com.hospital.model.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientData, Integer> {

    List<PatientData> findTopByOrderByIdDesc();
}
