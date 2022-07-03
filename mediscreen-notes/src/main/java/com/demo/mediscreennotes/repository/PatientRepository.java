package com.demo.mediscreennotes.repository;

import com.demo.mediscreennotes.model.PatientNotes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<PatientNotes, Integer> {
    List<PatientNotes> findByPatientId(Long patientId);
}
