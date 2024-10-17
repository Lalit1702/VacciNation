package com.example.VacciNation.service;

import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient); //returns saved patient
    }
}
