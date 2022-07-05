package com.demo.mediscreenwebapp.service;


import com.demo.mediscreenwebapp.model.Gender;
import com.demo.mediscreenwebapp.model.Patient;
import com.demo.mediscreenwebapp.model.PatientNotes;
import com.demo.mediscreenwebapp.model.RiskLevel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

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

    public RiskLevel riskLevel(Patient patient) {
        List<PatientNotes> notes = getAllPatientNotesFromId(patient.getId());
        int wordCount = 0;
        for(PatientNotes note : notes) {
            String string = note.getDoctorNotes().toLowerCase(Locale.ROOT);
            wordCount += StringUtils.countOccurrencesOf(string, "taille");
            wordCount += StringUtils.countOccurrencesOf(string, "poids");
            wordCount += StringUtils.countOccurrencesOf(string, "hémoglobine a1c");
            wordCount += StringUtils.countOccurrencesOf(string, "microalbumine");
            wordCount += StringUtils.countOccurrencesOf(string, "fumeur");
            wordCount += StringUtils.countOccurrencesOf(string, "anormal");
            wordCount += StringUtils.countOccurrencesOf(string, "cholésterol");
            wordCount += StringUtils.countOccurrencesOf(string, "vertige");
            wordCount += StringUtils.countOccurrencesOf(string, "rechute");
            wordCount += StringUtils.countOccurrencesOf(string, "réaction");
            wordCount += StringUtils.countOccurrencesOf(string, "anticorps");

        }


        if(ChronoUnit.YEARS.between(LocalDate.parse(patient.getBirthdate()), LocalDate.now().minusYears(30)) >= 30) {
            if(wordCount < 2) return RiskLevel.NONE;
            if(wordCount >=2 && wordCount <= 5) return RiskLevel.BORDERLINE;
            if(wordCount >=6 && wordCount < 8) return RiskLevel.DANGER;
            if(wordCount >=8) return RiskLevel.EARLY_ONSET;
        }
        if(patient.getGender() == Gender.MALE || patient.getGender() == Gender.OTHER) {
            if(wordCount < 3) return RiskLevel.NONE;
            if(wordCount >= 3 && wordCount <= 4) return RiskLevel.DANGER;
            if(wordCount >= 5) return RiskLevel.EARLY_ONSET;
        }
        if(wordCount < 4) return RiskLevel.NONE;
        if(wordCount >= 4 && wordCount <= 6) return RiskLevel.DANGER;
        if(wordCount >= 7) return RiskLevel.EARLY_ONSET;

        return RiskLevel.EARLY_ONSET;
    }
}
