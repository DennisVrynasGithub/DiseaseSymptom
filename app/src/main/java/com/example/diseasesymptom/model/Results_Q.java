package com.example.diseasesymptom.model;

/**
 * Created by Dennis on 8/3/2018.
 */

public class Results_Q {
    private String id_2,Date,Score;
//
    public Results_Q(String id_2, String Date, String Score) {
        this.id_2 = id_2;
        this.Date = Date;
        this.Score = Score;
    }

    public String getId() {
        return id_2;
    }

    public void setId(String id_2) {
        this.id_2 = id_2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String Score) {
        this.Score = Score;
    }
}
