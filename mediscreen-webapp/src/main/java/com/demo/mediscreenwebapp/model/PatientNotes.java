package com.demo.mediscreenwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientNotes {
    private Long patientId;
    private String doctorNotes;
}
