package com.hospital.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.model.PatientData;
import com.hospital.repository.PatientRepository;

@Component
public class TokenService {

	@Autowired
	PatientRepository patientRepo;
	
	int token=0;
	public PatientData generateToken(String name, int contact_number) {
		
		PatientData patient=new PatientData();
		patient.setName(name);
		patient.setContact_number(contact_number);
		Date date=new Date();
		patient.setBookingDate(date);
		
		List<PatientData> patientlist=(List<PatientData>) patientRepo.findTopByOrderByIdDesc();
		Date date1=new Date();
		PatientData last_token=patientlist.get(0);
		//first entry
		if(last_token!=null) {
		
			date1=last_token.getBookingDate();
		
			if(date1.compareTo(date)!=0) 
				token=1;
			else
				token=last_token.getToken()+1;
		}
		else {
			token=1;
		}
		patient.setToken(token);
		patientRepo.save(patient);
		return patient;
	}
}
