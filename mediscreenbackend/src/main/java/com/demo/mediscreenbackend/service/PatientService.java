package com.demo.mediscreenbackend.service;


import com.demo.mediscreenbackend.model.Patient;
import com.demo.mediscreenbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    public Patient newPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }
}
