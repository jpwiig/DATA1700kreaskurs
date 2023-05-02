package com.data1700.kraeskursEks2022.pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ikke en del av eksamen, bruker ROM for å lage database
@Table (name = "kunde")
public class kunde {
    @Id
    @GeneratedValue
    private int id; // endret for at jpa skal fungere
    private String name;
    private String phone;
    private String mail;
    private String password;

    public kunde() {
    }

    public kunde(int id, String name, String phone, String mail, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.password = password;
    }

    public int getKid() {
        return id;
    }

    public void setKid(int i) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
