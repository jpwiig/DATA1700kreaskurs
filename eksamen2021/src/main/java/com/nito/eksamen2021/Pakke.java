package com.nito.eksamen2021;

public class Pakke {
    public int pid;
    public int kid;
    public double volum;
    public double vekt;

    public Pakke(int pid, int kid, double volum, double vekt) {
        this.pid = pid;
        this.kid = kid;
        this.volum = volum;
        this.vekt = vekt;
    }

    public Pakke() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public double getVekt() {
        return vekt;
    }

    public void setVekt(double vekt) {
        this.vekt = vekt;
    }
}
