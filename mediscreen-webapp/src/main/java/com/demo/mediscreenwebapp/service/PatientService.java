package com.demo.mediscreenwebapp.service;

import com.demo.mediscreenwebapp.model.Patient;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PatientService {
    private static final String baseUrl = "http://localhost:8081/";
    private WebClient webClient = WebClient.create(baseUrl);
    PatientRestClient patientRestClient = new PatientRestClient(webClient);

    public List<Patient> getAllPatients() {
        return patientRestClient.retrieveAllPatients();
    }

    public Patient newPatient(Patient patient) {
        return patientRestClient.addNewPatient(patient);
    }
}
