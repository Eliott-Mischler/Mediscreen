package com.demo.mediscreenwebapp.service;


import com.demo.mediscreenwebapp.model.PatientNotes;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PatientNotesService {
    private static final String baseUrl = "http://localhost:8082";
    private WebClient webClient = WebClient.create(baseUrl);

    PatientNotesRestClient patientNotesRestClient = new PatientNotesRestClient(webClient);

    public List<PatientNotes> getAllPatientNotesFromId(Long patientId) {
        return patientNotesRestClient.retrieveAllNotesForPatient(patientId);
    }

    public PatientNotes newPatientNotes(PatientNotes patientNotes) {
        return patientNotesRestClient.postNotesForPatient(patientNotes);
    }
}
