package com.example.springbatch.Models.doqtoor_admin_kpi;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medecin")
public class Medecin {
    @Id
    private int id;
    private String title;
    private String medecin_speciality;
    private long code_cnom;

    public Medecin(int id, String title, String medecin_speciality, long code_cnom) {
        this.id = id;
        this.title = title;
        this.medecin_speciality = medecin_speciality;
        this.code_cnom = code_cnom;
    }

    public Medecin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedecin_speciality() {
        return medecin_speciality;
    }

    public void setMedecin_speciality(String medecin_speciality) {
        this.medecin_speciality = medecin_speciality;
    }

    public long getCode_cnom() {
        return code_cnom;
    }

    public void setCode_cnom(long code_cnom) {
        this.code_cnom = code_cnom;
    }
}
