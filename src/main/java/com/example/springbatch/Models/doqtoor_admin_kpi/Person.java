package com.example.springbatch.Models.doqtoor_admin_kpi;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;

    @Column
    private String name;

    @Column
    private String height ;

    @Column
    private String address;

    public Person (){
        //For persistence
    }

    public Person(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
