package com.example.springbatch.Models.doqtoor_app;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.Cache;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PractitionerDetails implements Serializable {

    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String nationalId;
    @Column
    private String speciality;
    @Column
    private String exerciseRegion;
    @Column
    @Lob
    private String presentation;
    @Column
    private Boolean availability = false;
    @Column
    private Double consultationPrice;
    @Column
    private String cin;
    @Column
    private String taxRegistrationNumber;
    @Column
    private String availabilityHoursDescription;
    @Column
    private String rib;

    @OneToOne
    @MapsId
    @JsonIgnore
    private UserInfoDetails userInfoDetails;

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

    public UserInfoDetails getUserInfoDetails() {
        return userInfoDetails;
    }

    public void setUserInfoDetails(UserInfoDetails userInfoDetails) {
        this.userInfoDetails = userInfoDetails;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String practitionerPresentation) {
        this.presentation = practitionerPresentation;
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

    public void setAvailabilityHoursDescription(String hours) {
        this.availabilityHoursDescription = hours;
    }

    public String getRib() { return rib; }

    public void setRib(String rib) { this.rib = rib; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PractitionerDetails that = (PractitionerDetails) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PractitionerDetails{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", nationalId='" + nationalId + '\'' +
            ", speciality='" + speciality + '\'' +
            ", exerciseRegion='" + exerciseRegion + '\'' +
            ", presentation='" + presentation + '\'' +
            ", availability="   +availability + '\'' +
            ", userInfoDetails=" + userInfoDetails + '\'' +
            ", consultationPrice=" + consultationPrice + '\'' +
            ", cin=" + cin +'\'' +
            ", taxRegistrationNumber=" + taxRegistrationNumber + '\'' +
            ", availabilityHoursDescription =" + availabilityHoursDescription +'\'' +
            ", rib=" + rib +
            '}';
    }
}
