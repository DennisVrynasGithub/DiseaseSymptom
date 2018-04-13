package com.example.diseasesymptom.model;

/**
 * Created by Dennis on 8/3/2018.
 */

public class Admin_user_list_result {
    private String user_id, user_name;

    public Admin_user_list_result(String user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public String getId() {
        return user_id;
    }

    public void setId(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String user_name) {
        this.user_name = user_name;
    }

}
