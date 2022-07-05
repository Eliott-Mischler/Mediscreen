package com.demo.mediscreenwebapp.service;

import com.demo.mediscreenwebapp.model.Patient;

import com.demo.mediscreenwebapp.model.PatientNotes;
import com.demo.mediscreenwebapp.model.RiskLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Locale;

@Service
public class PatientService {
    @Autowired
    private PatientNotesService patientNotesService;

    private static final String baseUrl = "http://localhost:8081/";
    private WebClient webClient = WebClient.create(baseUrl);
    PatientRestClient patientRestClient = new PatientRestClient(webClient);

    public List<Patient> getAllPatients() {
        return patientRestClient.retrieveAllPatients();
    }

    public Patient newPatient(Patient patient) {
        return patientRestClient.addNewPatient(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRestClient.retrievePatientById(id);
    }


    public List<Patient> updateAllPatients() {
        List<Patient> patients = getAllPatients();
        for(Patient p : patients) {
            p.setRiskLevel(patientNotesService.riskLevel(p));

        }
        return patients;
    }


}
