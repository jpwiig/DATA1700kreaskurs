package com.nito.eksamen2021;
/*
POJO
 */
public class Poststed {
    public String sted;
    public String postnr;


    public Poststed(String sted, String postnr) {
        this.sted = sted;
        this.postnr = postnr;
    }

    public Poststed(){

    }
    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }
}
