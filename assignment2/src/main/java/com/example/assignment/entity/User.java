package com.example.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
    @Id
    String id;

    String password;
    String fullname;
    String email;
    Boolean admin;

    public User(){
    }
    public User(String id, String password, String fullname, String email, Boolean admin) {
        this.id = id;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String inThongTin(){
        return "User:{id:'" + id + "', password:'" +  password + "', fullname:'" +  fullname + "', email:'" +  email + "', admin:'" + (admin? "Admin" : "Client")+"'}";
    }


}
