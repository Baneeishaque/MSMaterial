package com.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.PatientData;

public interface PatientRepository extends JpaRepository<PatientData, Integer> {

	List<PatientData> findTopByOrderByIdDesc();
}
