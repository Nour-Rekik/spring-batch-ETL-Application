package com.example.springbatch.Models.doqtoor_app;

import javax.persistence.Column;
import javax.persistence.Lob;

public class PractionnerInput {
    private Long id;
    private String title;
    private String nationalId;
    private String speciality;
    private String exerciseRegion;
    private String presentation;
    private Boolean availability = false;
    private Double consultationPrice;
    private String cin;
    private String taxRegistrationNumber;
    private String availabilityHoursDescription;
    private String rib;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getExerciseRegion() {
        return exerciseRegion;
    }

    public void setExerciseRegion(String exerciseRegion) {
        this.exerciseRegion = exerciseRegion;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Double getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(Double consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public String getAvailabilityHoursDescription() {
        return availabilityHoursDescription;
    }

    public void setAvailabilityHoursDescription(String availabilityHoursDescription) {
        this.availabilityHoursDescription = availabilityHoursDescription;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
}
