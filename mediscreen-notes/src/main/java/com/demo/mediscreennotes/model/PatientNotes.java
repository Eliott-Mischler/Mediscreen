package com.demo.mediscreennotes.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientNotes {
    private Long patientId;
    private String doctorNotes;
}
