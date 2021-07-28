package com.example.springbatch.Repositories.doqtoor_admin_kpi;

import com.example.springbatch.Models.doqtoor_admin_kpi.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("SELECT name FROM Person p WHERE p.name LIKE %:personName% ")
    String findByName(String personName);}
