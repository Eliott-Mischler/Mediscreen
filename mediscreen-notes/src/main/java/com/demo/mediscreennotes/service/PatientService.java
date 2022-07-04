package com.demo.mediscreennotes.service;

import com.demo.mediscreennotes.repository.PatientRepository;
import com.demo.mediscreennotes.model.PatientNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<PatientNotes> getAllNotesForPatient(Long patientId) {
        return patientRepository.findByPatientId(patientId);
    }
    public PatientNotes newPatientNotes(PatientNotes patientNotes) {
             return this.patientRepository.save(patientNotes);
    }
}
