package com.data1700.kraeskursEks2022.pojo;

import jakarta.persistence.*;

import java.util.Date;

//ikke en del av eksamen
@Entity
@Table(name = "bestilling")
public class bestilling {
    @Id

    @GeneratedValue
    private int bid;

    private int kid;
    private int bord;
    private Date motatt;
    private String varer;


    public bestilling() {
    }

    public bestilling(int bid, int kid, int bord, Date motatt, String varer) {
        this.bid = bid;
        this.kid = kid;
        this.bord = bord;
        this.motatt = motatt;
        this.varer = varer;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getBord() {
        return bord;
    }

    public void setBord(int bord) {
        this.bord = bord;
    }

    public Date getMotatt() {
        return motatt;
    }

    public void setMotatt(Date motatt) {
        this.motatt = motatt;
    }

    public String getVarer() {
        return varer;
    }

    public void setVarer(String varer) {
        this.varer = varer;
    }
}
