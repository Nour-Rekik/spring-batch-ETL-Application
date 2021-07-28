package com.example.springbatch.Repositories.doqtoor_app;

import com.example.springbatch.Models.doqtoor_app.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
