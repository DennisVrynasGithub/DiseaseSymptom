package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.diseasesymptom.model.RegisterRequest;
import com.example.diseasesymptom.model.RegisterResponse;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity {

    TextView txRegisterSuccess, txRegisterFailed;
    EditText editTextName, editTextPassword, editTextEmail, editTextCountry, editTextGender, editTextAge;
    Button button_register, button_back;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txRegisterSuccess = findViewById(R.id.txRegisterSuccess);
        txRegisterFailed = findViewById(R.id.txRegisterFailed);

        txRegisterSuccess.setVisibility(View.INVISIBLE);
        txRegisterFailed.setVisibility(View.INVISIBLE);

        editTextName = findViewById(R.id.editText_user_name1);
        editTextPassword = findViewById(R.id.editTextUserPassword);
        editTextEmail = findViewById(R.id.editText_user_email2);
        editTextCountry = findViewById(R.id.editText_country);
        editTextGender = findViewById(R.id.editText_gender);
        editTextAge = findViewById(R.id.editText_age);

        button_register = findViewById(R.id.bn_register2);
        button_back = findViewById(R.id.btn_register_back);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });

        editTextGender.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (Objects.equals(editTextName.getText().toString(), "")) {
                        Toast.makeText(RegisterActivity.this, "Enter user name", Toast.LENGTH_LONG).show();
                    } else {
                        if (Objects.equals(editTextPassword.getText().toString(), "")) {
                            Toast.makeText(RegisterActivity.this, "Enter user password", Toast.LENGTH_LONG).show();
                        } else {
                            if (Objects.equals(editTextEmail.getText().toString(), "")) {
                                Toast.makeText(RegisterActivity.this, "Enter user email", Toast.LENGTH_LONG).show();
                            } else {
                                if (Objects.equals(editTextCountry.getText().toString(), "")) {
                                    Toast.makeText(RegisterActivity.this, "Enter country", Toast.LENGTH_LONG).show();
                                } else {
                                    if (Objects.equals(editTextAge.getText().toString(), "")) {
                                        Toast.makeText(RegisterActivity.this, "Enter user gender", Toast.LENGTH_LONG).show();
                                    } else {
                                        if (Objects.equals(editTextGender.getText().toString(), "")) {
                                            Toast.makeText(RegisterActivity.this, "Enter user age", Toast.LENGTH_LONG).show();
                                        } else {

                                            register(
                                                    editTextName.getText().toString(),
                                                    editTextPassword.getText().toString(),
                                                    editTextEmail.getText().toString(),
                                                    editTextAge.getText().toString(),
                                                    editTextCountry.getText().toString(),
                                                    editTextGender.getText().toString()
                                            );

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextName.getText().toString(), "")) {
                    Toast.makeText(RegisterActivity.this, "Enter user name", Toast.LENGTH_LONG).show();
                } else {
                    if (Objects.equals(editTextPassword.getText().toString(), "")) {
                        Toast.makeText(RegisterActivity.this, "Enter user password", Toast.LENGTH_LONG).show();
                    } else {
                        if (Objects.equals(editTextEmail.getText().toString(), "")) {
                            Toast.makeText(RegisterActivity.this, "Enter user email", Toast.LENGTH_LONG).show();
                        } else {
                            if (Objects.equals(editTextCountry.getText().toString(), "")) {
                                Toast.makeText(RegisterActivity.this, "Enter country", Toast.LENGTH_LONG).show();
                            } else {
                                if (Objects.equals(editTextGender.getText().toString(), "")) {
                                    Toast.makeText(RegisterActivity.this, "Enter user gender", Toast.LENGTH_LONG).show();
                                } else {
                                    if (Objects.equals(editTextAge.getText().toString(), "")) {
                                        Toast.makeText(RegisterActivity.this, "Enter user age", Toast.LENGTH_LONG).show();
                                    } else {

                                        register(
                                                editTextName.getText().toString(),
                                                editTextPassword.getText().toString(),
                                                editTextEmail.getText().toString(),
                                                editTextAge.getText().toString(),
                                                editTextCountry.getText().toString(),
                                                editTextGender.getText().toString()
                                        );
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    private void register(String userName, String userPassword, String userEmail, String userAge, String userCountry, String userGendre) {
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Invalid email!", Toast.LENGTH_LONG).show();
            return;
        }

        RegisterRequest request = new RegisterRequest(userEmail, userPassword, userName, userGendre, userCountry, userAge);
        api.register(request).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    txRegisterSuccess.setVisibility(View.VISIBLE);
                    txRegisterFailed.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txRegisterSuccess.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    txRegisterSuccess.setVisibility(View.INVISIBLE);
                    txRegisterFailed.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txRegisterFailed.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Register failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
