package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.diseasesymptom.R;

public class FindQuestionnaireActivity extends AppCompatActivity {

    Button enter_questionnaire_1, enter_questionnaire_2, enter_questionnaire_3, enter_questionnaire_4, enter_questionnaire_5, enter_questionnaire_6, button_back;
    String json_user_id, json_user_email, json_user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_questionnaire);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        enter_questionnaire_1 = findViewById(R.id.btn_q1);
        enter_questionnaire_2 = findViewById(R.id.btn_q2);
        enter_questionnaire_3 = findViewById(R.id.btn_q3);
        enter_questionnaire_4 = findViewById(R.id.btn_q4);
        enter_questionnaire_5 = findViewById(R.id.btn_q5);
        enter_questionnaire_6 = findViewById(R.id.btn_q6);
        button_back = findViewById(R.id.btn_quest_back);

        enter_questionnaire_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire1Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        enter_questionnaire_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire2Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        enter_questionnaire_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire3Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        enter_questionnaire_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire4Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        enter_questionnaire_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire5Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        enter_questionnaire_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, Questionnaire6Activity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindQuestionnaireActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                FindQuestionnaireActivity.this.finish();

            }
        });
    }
}
