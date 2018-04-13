package com.example.diseasesymptom.model;

/**
 * Created by Dennis on 8/1/2018.
 */

public class Players {

    private String id, name, a2z, fact, description;

    public Players(String id, String name, String a2z, String fact, String description) {
        this.id = id;
        this.name = name;
        this.a2z = a2z;
        this.fact = fact;
        this.description = description;
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
        return a2z;
    }

    public void setA2z(String a2z) {
        this.a2z = a2z;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
