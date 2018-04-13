package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.LoginRequest;
import com.example.diseasesymptom.model.LoginResponse;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Button button_login, button_back;
    EditText editTextEmail, editTextPassword;
    String json_user_id;

    public static final String MY_PREFS_NAME_LOGIN = "MyLogin";

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button_login = findViewById(R.id.btn_login2);
        button_back = findViewById(R.id.btnLoginBack);
        editTextEmail = findViewById(R.id.et_user_email);
        editTextPassword = findViewById(R.id.et_user_password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                }
                return false;
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }

    private void login(String userEmail, String password) {
        if (userEmail == null || password == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Invalid email!", Toast.LENGTH_LONG).show();
            return;
        }

        if (password.length() == 0) {
            Toast.makeText(this, "Empty password!", Toast.LENGTH_LONG).show();
            return;
        }

        LoginRequest request = new LoginRequest(userEmail, password);
        api.login(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);

                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME_LOGIN, MODE_PRIVATE).edit();
                    editor.putString("user_id_sp", response.body().getUser_id());
                    editor.putString("json_user_email_sp", editTextEmail.getText().toString());
                    editor.putString("json_user_password_sp", editTextPassword.getText().toString());
                    editor.apply();
                    startActivity(intent);
                    LoginActivity.this.finish();
                } else {
                    //error
                    Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
