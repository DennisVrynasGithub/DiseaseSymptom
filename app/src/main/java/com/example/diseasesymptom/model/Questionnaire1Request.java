package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

public class Questionnaire1Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("medication")
    private String medication;
    @SerializedName("illnes")
    private String illnes;
    @SerializedName("procedure")
    private String procedure;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire1Request() {
    }

    public Questionnaire1Request(String gender, String age, String medication, String illnes, String procedure, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.medication = medication;
        this.illnes = illnes;
        this.procedure = procedure;
        this.sum = sum;
        this.id_2 = id_2;
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

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }
}
