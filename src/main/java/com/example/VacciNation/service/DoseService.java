package com.example.VacciNation.service;

import com.example.VacciNation.Enum.VaccineBrand;
import com.example.VacciNation.exception.PatientNotFoundException;
import com.example.VacciNation.model.Dose;
import com.example.VacciNation.model.Patient;
import com.example.VacciNation.repository.DoseRepository;
import com.example.VacciNation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccineBrand vaccineBrand) {
        //1.check whether the patient is valid or not
        Optional<Patient> patientOptional=patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient id");
        }

        Patient patient = patientOptional.get();

        if(patient.isVaccinated()){
            throw new RuntimeException("Patient is Already Vaccinated");
        }
        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));

        dose.setPatient(patient);

        patientRepository.save(patient);
        return doseRepository.save(dose);

    }
}
