package com.data1700.kraeskursEks2022.pojo;
//ikke en del av ekasamen

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name = "vare")
public class vare {
    @Id
    @GeneratedValue
    private int id; //endret for at jpa skal fungere
    private String varenavn;
    private int  pris;
    private int antall;

    public vare() {
    }

    public vare(int id, String varenavn, int pris, int antall) {
        this.id = id;
        this.varenavn = varenavn;
        this.pris = pris;
        this.antall = antall;
    }

    public int getid() {
        return id;
    }

    public void setVid(int id) {
        this.id = id;
    }

    public String getVarenavn() {
        return varenavn;
    }

    public void setVarenavn(String varenavn) {
        this.varenavn = varenavn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }
}

