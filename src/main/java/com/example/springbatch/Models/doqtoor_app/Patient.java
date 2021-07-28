package com.example.springbatch.Models.doqtoor_app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    private int id;
    private String nom;
    private int prenom;

    public Patient(int id, String nom, int prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Patient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrenom() {
        return prenom;
    }

    public void setPrenom(int prenom) {
        this.prenom = prenom;
    }
}
