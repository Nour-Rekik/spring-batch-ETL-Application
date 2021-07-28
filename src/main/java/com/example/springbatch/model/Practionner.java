package com.example.springbatch.model;

public class Practionner {
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
        Rib = rib;
    }

    public String gettaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void settaxRegistrationNumber(String taxRegistrationNumber) {
        taxRegistrationNumber = taxRegistrationNumber;
    }

}
