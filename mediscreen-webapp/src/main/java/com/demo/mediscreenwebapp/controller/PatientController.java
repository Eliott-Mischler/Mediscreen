package com.demo.mediscreenwebapp.controller;

import com.demo.mediscreenwebapp.model.Patient;
import com.demo.mediscreenwebapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("list")
    public ModelAndView listGet(Model model) {
        return new ModelAndView("patients_list", "patients", patientService.getAllPatients());
    }


    @GetMapping("add-patient")
    public ModelAndView addPatientGet() {
        return new ModelAndView("add_patient", "patient", new Patient());
    }

    @PostMapping("add-patient")
    public ModelAndView addPatientPost(@ModelAttribute Patient patient, Model model) {
        try {
            patientService.newPatient(patient);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return listGet(model);
    }
}
