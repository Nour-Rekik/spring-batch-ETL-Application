package com.example.springbatch.Models.doqtoor_admin_kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    private int id;
    private String username;
    private String password;

}
