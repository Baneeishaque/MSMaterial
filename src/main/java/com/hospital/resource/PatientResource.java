package com.hospital.resource;

import com.hospital.model.PatientData;
import com.hospital.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientResource {

    final TokenService tokenService;

    public PatientResource(TokenService tokenService) {

        this.tokenService = tokenService;
    }

    @PostMapping("/booktoken")
    public PatientData bookToken(@RequestParam("name") String name, @RequestParam("contactNumber") String contactNumber) {

        return tokenService.generateToken(name, contactNumber);
    }
}
