package com.example.springbatch.Models.doqtoor_admin_kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    private int id;
     private String coach_speciality;

    public Coach(int id, String coach_speciality) {
        this.id = id;
        this.coach_speciality = coach_speciality;
    }

    public Coach() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoach_speciality() {
        return coach_speciality;
    }

    public void setCoach_speciality(String coach_speciality) {
        this.coach_speciality = coach_speciality;
    }
}
