package com.example.springbatch;

import com.example.springbatch.Models.doqtoor_admin_kpi.Person;
import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.example.springbatch.Models.doqtoor_app.Patient;
import com.example.springbatch.Repositories.doqtoor_admin_kpi.PersonRepository;
import com.example.springbatch.Repositories.doqtoor_admin_kpi.PractitionerRepository;
import com.example.springbatch.Repositories.doqtoor_app.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBatchApplication {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PractitionerRepository practitionerRepository;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getPatients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/getPractitioners")
    public List<Practitioner> getPractitioners(){
        return practitionerRepository.findAll();
    }
    @GetMapping("/getPersons")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

}
