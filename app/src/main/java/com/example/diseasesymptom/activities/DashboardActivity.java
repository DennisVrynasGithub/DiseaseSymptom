package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.diseasesymptom.R;

public class DashboardActivity extends AppCompatActivity {

    protected Button button_dashboard_login, button_dashboard_register;
    String json_user_id,json_user_email,json_user_password;
    public static final String MY_PREFS_NAME_LOGIN = "MyLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dashboard);


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME_LOGIN, MODE_PRIVATE);
        json_user_id = prefs.getString("user_id_sp", null);
        json_user_email = prefs.getString("json_user_email_sp", null);
        json_user_password = prefs.getString("json_user_password_sp", null);

        if (json_user_id!=null && json_user_email!=null && json_user_password!=null) {
            Intent intent = new Intent(DashboardActivity.this, WelcomeActivity.class);
            startActivity(intent);
            DashboardActivity.this.finish();
        } else {

            button_dashboard_login = findViewById(R.id.btn_dashboard_login);
            button_dashboard_register = findViewById(R.id.btn_register);

            button_dashboard_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                    startActivity(intent);
                    DashboardActivity.this.finish();
                }
            });

            button_dashboard_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    DashboardActivity.this.finish();
                }
            });
        }
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//     // The rest of your onStart() code.
//        EasyTracker.getInstance(this).activityStart(this);  // Add this method.
//    }

}
