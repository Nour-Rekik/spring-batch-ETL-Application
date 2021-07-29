package com.example.springbatch.Models.doqtoor_admin_kpi;

import com.example.springbatch.Models.doqtoor_admin_kpi.enumerations.Admin_Roles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Admin_Roles role;

    public Admin(int id, String login, String password, String firstName, String lastName, Admin_Roles role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Admin_Roles getRole() {
        return role;
    }

    public void setRole(Admin_Roles role) {
        this.role = role;
    }
}
