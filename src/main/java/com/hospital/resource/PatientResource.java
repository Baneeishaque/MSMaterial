package com.hospital.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.PatientData;
import com.hospital.service.TokenService;

@RestController
public class PatientResource {

	@Autowired
	TokenService tokenService;
	
	@PostMapping("/booktoken")
	public PatientData bookToken(@RequestParam("name") String name,@RequestParam("contactNumber") int contactNumber) {
		PatientData token=tokenService.generateToken(name, contactNumber);
		return token;
	}
}
