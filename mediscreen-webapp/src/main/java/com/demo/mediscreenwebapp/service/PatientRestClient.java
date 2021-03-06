package com.demo.mediscreenwebapp.service;

import com.demo.mediscreenwebapp.model.Patient;
import com.demo.mediscreenwebapp.model.PatientNotes;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.demo.mediscreenwebapp.constants.PatientAPIEndpoints.*;

public class PatientRestClient {
    private WebClient webClient;
    public PatientRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<Patient> retrieveAllPatients() {
        return webClient.get().uri(GET_ALL_PATIENTS)
                .retrieve()
                .bodyToFlux(Patient.class)
                .collectList()
                .block();
    }

    public Patient addNewPatient(Patient patient) {
        return webClient.post().uri(ADD_PATIENT)
                .bodyValue(patient)
                .retrieve()
                .bodyToMono(Patient.class)
                .block();
    }

    public Patient retrievePatientById(Long id) {
        return webClient.get().uri(GET_PATIENT_BY_ID, id)
                .retrieve()
                .bodyToMono(Patient.class)
                .block();
    }


}
