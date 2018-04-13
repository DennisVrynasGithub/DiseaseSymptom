package com.example.diseasesymptom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//reated by Dennis on 10/1/2018.

public class Quest1 {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("medication")
    @Expose
    private String medication;

    @SerializedName("illnes")
    @Expose
    private String illnes;

    @SerializedName("procedure_1")
    @Expose
    private String procedure_1;

    @SerializedName("id_2")
    @Expose
    private String id_2;

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Score")
    @Expose
    private Integer Score;

    public Quest1(String gender, String age, String medication, String illnes, String procedure_1, String id_2) {
        this.gender = gender;
        this.age = age;
        this.medication = medication;
        this.illnes = illnes;
        this.procedure_1 = procedure_1;
        this.id_2 = id_2;
    }

    public Quest1() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    public String getProcedure_1() {
        return procedure_1;
    }

    public void setProcedure_1(String procedure_1) {
        this.procedure_1 = procedure_1;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer Score) {
        this.Score = Score;
    }
}
