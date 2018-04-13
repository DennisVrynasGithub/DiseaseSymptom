package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class Questionnaire3Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("chronic_problem")
    private String chronic_problem;
    @SerializedName("years")
    private String years;
    @SerializedName("medical")
    private String medical;
    @SerializedName("other_illnes")
    private String other_illnes;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire3Request() {
    }

    public Questionnaire3Request(String gender, String age, String chronic_problem, String years, String medical, String other_illnes, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.chronic_problem = chronic_problem;
        this.years = years;
        this.medical = medical;
        this.other_illnes = other_illnes;
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

    public String getChronic_problem() {
        return chronic_problem;
    }

    public void setChronic_problem(String chronic_problem) {
        this.chronic_problem = chronic_problem;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getOther_illnes() {
        return other_illnes;
    }

    public void setOther_illnes(String other_illnes) {
        this.other_illnes = other_illnes;
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
