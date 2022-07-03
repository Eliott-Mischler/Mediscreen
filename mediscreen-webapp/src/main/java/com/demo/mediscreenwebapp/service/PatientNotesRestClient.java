package com.demo.mediscreenwebapp.service;

import com.demo.mediscreenwebapp.model.PatientNotes;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.demo.mediscreenwebapp.constants.PatientNotesAPIEndpoints.PATIENT_NOTES_BY_ID;

public class PatientNotesRestClient {
    private WebClient webClient;

    public PatientNotesRestClient(WebClient webClient) { this.webClient = webClient; }

    public List<PatientNotes> retrieveAllNotesForPatient(Long patientId) {
        return webClient.get().uri(PATIENT_NOTES_BY_ID, patientId)
                .retrieve()
                .bodyToFlux(PatientNotes.class)
                .collectList()
                .block();
    }

    public PatientNotes postNotesForPatient(PatientNotes patientNotes) {
        return webClient.post().uri(PATIENT_NOTES_BY_ID, patientNotes.getPatientId())
                .bodyValue(patientNotes)
                .retrieve()
                .bodyToMono(PatientNotes.class)
                .block();
    }
}
