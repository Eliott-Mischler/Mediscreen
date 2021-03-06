package com.demo.mediscreenbackend.controller;

import com.demo.mediscreenbackend.model.Gender;
import com.demo.mediscreenbackend.model.Patient;
import com.demo.mediscreenbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("allPatients")
    public List<Patient> getAllPatients() {
        return this.patientService.getAllPatients();
    }

    @PostMapping("addPatient")
    public Patient postAddPatient(@RequestBody Patient patient) {
        return this.patientService.newPatient(patient);
    }

    @GetMapping("patients/{id}")
    public Patient getPatientFromId(@PathVariable("id") Long id) {
        return patientService.getPatientById(id);
    }
}
