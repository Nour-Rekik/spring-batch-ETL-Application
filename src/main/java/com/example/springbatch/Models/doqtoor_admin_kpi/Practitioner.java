package com.example.springbatch.Models.doqtoor_admin_kpi;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Practitioner {
    private Long id;
    private String RegionExercise ;
    private String Rib ;
    private String taxRegistrationNumber ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRegionExercise() {
        return RegionExercise;
    }

    public void setRegionExercise(String regionExercise) {
        RegionExercise = regionExercise;
    }


    public String getRib() {
        return Rib;
    }

    public void setRib(String rib) {
        this.Rib = rib;
    }

    public String gettaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void settaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

}
