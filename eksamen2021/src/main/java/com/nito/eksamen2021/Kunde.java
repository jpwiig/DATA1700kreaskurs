package com.nito.eksamen2021;

/*
POJO
 */
public class Kunde {
    private String fornavn;
    private String etternavn;
    private String adresse;
    private String postnr;
    private String Telefonnr;
    private String Epost;

    public Kunde(String fornavn, String etternavn, String adresse, String postnr, String telefonnr, String epost) {

        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.postnr = postnr;
        Telefonnr = telefonnr;
        Epost = epost;
    }

    public Kunde() {
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getTelefonnr() {
        return Telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        Telefonnr = telefonnr;
    }

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }
}
