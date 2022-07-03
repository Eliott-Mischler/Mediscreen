package com.demo.mediscreenwebapp.controller;


import com.demo.mediscreenwebapp.model.PatientNotes;
import com.demo.mediscreenwebapp.service.PatientNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientNotesController {
    @Autowired
    private PatientNotesService patientNotesService;

    @GetMapping("/patient-notes/{id}")
    public ModelAndView getPatientNotes(@PathVariable("id") Long id, Model model) {
        model.addAttribute("patientId", id);
        return new ModelAndView("patient_notes", "patientNotes", patientNotesService.getAllPatientNotesFromId(id));
    }

    @GetMapping("/patient-notes/{id}/add")
    public ModelAndView getAddPatientNotes(@PathVariable("id") Long patientId, Model model) {
        model.addAttribute("patientNotes", new PatientNotes());
        return new ModelAndView("patient_notes_form", "patientId", patientId);
    }

    @PostMapping("patient-notes/{id}/add")
    public ModelAndView postAddPatientNotes(@PathVariable("id") Long patientId, @ModelAttribute PatientNotes patientNotes, Model model) {
        patientNotes.setPatientId(patientId);
        this.patientNotesService.newPatientNotes(patientNotes);
        return getPatientNotes(patientId, model);
    }
}
