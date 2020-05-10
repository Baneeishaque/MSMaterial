package com.hospital.service;

import com.hospital.model.PatientData;
import com.hospital.repository.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TokenService {

    final PatientRepository patientRepo;
    int token;

    public TokenService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public PatientData generateToken(String name, String contact_number) {

        PatientData patient = new PatientData();
        patient.setName(name);
        patient.setContact_number(contact_number);
        Date date = new Date();
        patient.setBookingDate(date);

        List<PatientData> patientList = patientRepo.findTopByOrderByIdDesc();

        if (patientList.size() > 0) {

            PatientData lastToken = patientList.get(0);
            if (lastToken.getBookingDate().compareTo(date) != 0)

                token = 1;

            else

                token = lastToken.getToken() + 1;

        } else {

            token = 1;
        }
        patient.setToken(token);
        patientRepo.save(patient);
        return patient;
    }
}
