package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.ProfileChangeAgeRequest;
import com.example.diseasesymptom.model.ProfileChangeAgeResponse;
import com.example.diseasesymptom.model.ProfileChangeCountryRequest;
import com.example.diseasesymptom.model.ProfileChangeCountryResponse;
import com.example.diseasesymptom.model.ProfileChangeNameRequest;
import com.example.diseasesymptom.model.ProfileChangeNameResponse;
import com.example.diseasesymptom.model.ProfileChangePasswordRequest;
import com.example.diseasesymptom.model.ProfileChangePasswordResponse;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    String json_user_id, json_user_email, json_user_password;
    EditText editTextName, editTextPassword, editTextCountry, editTextAge;
    Button button_change_name, button_change_password, button_change_country, button_change_age, button_back;
    TextView txProfileName, txProfilePasword, txProfileCountry, txProfileAge;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button_change_name = findViewById(R.id.btn_change_name);
        button_change_password = findViewById(R.id.btn_change_password);
        button_change_country = findViewById(R.id.btn_change_country);
        button_change_age = findViewById(R.id.btn_change_age);
        button_back = findViewById(R.id.btn_profile_back);
        editTextName = findViewById(R.id.editTextProfileName);
        editTextPassword = findViewById(R.id.editTextProfilePassword);
        editTextCountry = findViewById(R.id.editTextProfileCountry);
        editTextAge = findViewById(R.id.editTextProfileAge);
        txProfileName = findViewById(R.id.txProfileName);
        txProfilePasword = findViewById(R.id.txProfilePasword);
        txProfileCountry = findViewById(R.id.txProfileCountry);
        txProfileAge = findViewById(R.id.txProfileAge);

        txProfileName.setVisibility(View.INVISIBLE);
        txProfilePasword.setVisibility(View.INVISIBLE);
        txProfileCountry.setVisibility(View.INVISIBLE);
        txProfileAge.setVisibility(View.INVISIBLE);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                ProfileActivity.this.finish();

            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        button_change_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextName.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user name", Toast.LENGTH_SHORT).show();
                } else {
                    changeName(json_user_email, editTextName.getText().toString());
                }
            }
        });

        editTextName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changeName(json_user_email, editTextName.getText().toString());
                }
                return false;
            }
        });

        button_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextPassword.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user password", Toast.LENGTH_SHORT).show();
                } else {
                    changePassword(json_user_email, editTextPassword.getText().toString());
                }
            }
        });

        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changePassword(json_user_email, editTextPassword.getText().toString());
                }
                return false;
            }
        });

        button_change_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextCountry.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user country", Toast.LENGTH_SHORT).show();
                } else {
                    changeCountry(json_user_email, editTextCountry.getText().toString());
                }
            }
        });

        editTextCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changeCountry(json_user_email, editTextCountry.getText().toString());
                }
                return false;
            }
        });

        button_change_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(editTextAge.getText().toString(), "")) {
                    Toast.makeText(ProfileActivity.this, "Please enter new user age", Toast.LENGTH_SHORT).show();
                } else {
                    changeAge(json_user_email, editTextAge.getText().toString());
                }
            }
        });

        editTextAge.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changeAge(json_user_email, editTextAge.getText().toString());
                }
                return false;
            }
        });
    }

    private void changeName(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeNameRequest request = new ProfileChangeNameRequest(userName, userEmail);
        api.changeName(request).enqueue(new Callback<ProfileChangeNameResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeNameResponse> call, Response<ProfileChangeNameResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    txProfileName.setVisibility(View.VISIBLE);
                    txProfilePasword.setVisibility(View.INVISIBLE);
                    txProfileCountry.setVisibility(View.INVISIBLE);
                    txProfileAge.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txProfileName.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeNameResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changePassword(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangePasswordRequest request = new ProfileChangePasswordRequest(userName, userEmail);
        api.changePassword(request).enqueue(new Callback<ProfileChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ProfileChangePasswordResponse> call, Response<ProfileChangePasswordResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    txProfileName.setVisibility(View.INVISIBLE);
                    txProfilePasword.setVisibility(View.VISIBLE);
                    txProfileCountry.setVisibility(View.INVISIBLE);
                    txProfileAge.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txProfilePasword.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangePasswordResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changeCountry(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeCountryRequest request = new ProfileChangeCountryRequest(userName, userEmail);
        api.changeCountry(request).enqueue(new Callback<ProfileChangeCountryResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeCountryResponse> call, Response<ProfileChangeCountryResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    txProfileName.setVisibility(View.INVISIBLE);
                    txProfilePasword.setVisibility(View.INVISIBLE);
                    txProfileCountry.setVisibility(View.VISIBLE);
                    txProfileAge.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txProfileCountry.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeCountryResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changeAge(String userEmail, String userName) {
        if (userEmail == null || userName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        ProfileChangeAgeRequest request = new ProfileChangeAgeRequest(userName, userEmail);
        api.changeAge(request).enqueue(new Callback<ProfileChangeAgeResponse>() {
            @Override
            public void onResponse(Call<ProfileChangeAgeResponse> call, Response<ProfileChangeAgeResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {

                    txProfileName.setVisibility(View.INVISIBLE);
                    txProfilePasword.setVisibility(View.INVISIBLE);
                    txProfileCountry.setVisibility(View.INVISIBLE);
                    txProfileAge.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txProfileAge.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                } else {
                    //error
                    Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileChangeAgeResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
