package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class Questionnaire5Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("illnes")
    private String illnes;
    @SerializedName("medical")
    private String medical;
    @SerializedName("side_effect")
    private String side_effect;
    @SerializedName("new_medical")
    private String new_medical;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire5Request() {
    }

    public Questionnaire5Request(String gender, String age, String illnes, String medical, String side_effect, String new_medical, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes = illnes;
        this.medical = medical;
        this.side_effect = side_effect;
        this.new_medical = new_medical;
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

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

    public String getNew_medical() {
        return new_medical;
    }

    public void setNew_medical(String new_medical) {
        this.new_medical = new_medical;
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
