package com.demo.mediscreennotes.controller;

import com.demo.mediscreennotes.model.RiskLevel;
import com.demo.mediscreennotes.service.PatientService;
import com.demo.mediscreennotes.model.PatientNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patientNotes/{id}")
    public List<PatientNotes> getPatientNotes(@PathVariable("id") Long patientId) {
        return patientService.getAllNotesForPatient(patientId);
    }

    @PostMapping("/patientNotes/{id}")
    public PatientNotes postPatientNotes(@RequestBody PatientNotes patientNotes) {
        Long patientId = patientNotes.getPatientId();
        String doctorNotes = patientNotes.getDoctorNotes();
        return patientService.newPatientNotes(patientNotes);
    }


}
