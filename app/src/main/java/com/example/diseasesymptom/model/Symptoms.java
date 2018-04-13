package com.example.diseasesymptom.model;

/**
 * Created by Dennis on 9/1/2018.
 */

public class Symptoms {

    private String id,name,factid,fact;

    public Symptoms(String id, String name, String factid, String fact) {
        this.id = id;
        this.name = name;
        this.factid = factid;
        this.fact = fact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA2z() {
        return factid;
    }

    public void setA2z(String factid) {
        this.factid = factid;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
