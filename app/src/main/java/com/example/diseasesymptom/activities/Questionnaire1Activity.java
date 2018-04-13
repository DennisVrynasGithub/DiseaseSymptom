package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.Questionnaire1Request;
import com.example.diseasesymptom.model.Questionnaire1Response;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire1Activity extends AppCompatActivity {

    RadioGroup radioGroup, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    Button btn, btn_n1, btn_p2, btn_n2, btn_p3, btn_n3, btn_p4, btn_p5, btn_n4, btn_back;
    String json_user_password, json_user_email, json_user_id, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5;
    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, TX1, TX2, TX3, TX4, TX5;
    Integer in1, in2, in3, in4, in5;
    LinearLayout ln1, ln2, ln3, ln4, ln5;
    Integer sum;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire1);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        radioGroup = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup12);
        radioGroup3 = findViewById(R.id.radioGroup13);
        radioGroup4 = findViewById(R.id.radioGroup14);
        radioGroup5 = findViewById(R.id.radioGroup15);

        ln1 = findViewById(R.id.linearLayout31);
        ln2 = findViewById(R.id.linearLayout);
        ln3 = findViewById(R.id.linearLayout3);
        ln4 = findViewById(R.id.linearLayout2);
        ln5 = findViewById(R.id.linearLayout25);

        tx1 = findViewById(R.id.textView45);
        tx2 = findViewById(R.id.textView46);
        tx3 = findViewById(R.id.textView47);
        tx4 = findViewById(R.id.textView48);
        tx5 = findViewById(R.id.textView49);
        tx6 = findViewById(R.id.textView50);
        tx7 = findViewById(R.id.textView51);
        tx8 = findViewById(R.id.textView52);
        tx9 = findViewById(R.id.textView53);
        btn = findViewById(R.id.btn_q1_send);

        TX1 = findViewById(R.id.textView10);
        TX2 = findViewById(R.id.textView16);
        TX3 = findViewById(R.id.textView17);
        TX4 = findViewById(R.id.textView18);
        TX5 = findViewById(R.id.textView19);

        btn_n1 = findViewById(R.id.q1_n1);
        btn_back = findViewById(R.id.button6);
        btn_n2 = findViewById(R.id.q1_n2);
        btn_p2 = findViewById(R.id.q1_p2);
        btn_n3 = findViewById(R.id.q1_n3);
        btn_p3 = findViewById(R.id.q1_p3);
        btn_n4 = findViewById(R.id.q1_n4);
        btn_p4 = findViewById(R.id.q1_p4);
        btn_p5 = findViewById(R.id.q1_p5);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);
        tx4.setVisibility(View.INVISIBLE);
        tx5.setVisibility(View.INVISIBLE);
        tx6.setVisibility(View.INVISIBLE);
        tx7.setVisibility(View.INVISIBLE);
        tx8.setVisibility(View.INVISIBLE);
        tx9.setVisibility(View.INVISIBLE);

        ln2.setVisibility(View.INVISIBLE);
        ln3.setVisibility(View.INVISIBLE);
        ln4.setVisibility(View.INVISIBLE);
        ln5.setVisibility(View.INVISIBLE);

        btn_n2.setVisibility(View.INVISIBLE);
        btn_n3.setVisibility(View.INVISIBLE);
        btn_n4.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        btn_p2.setVisibility(View.INVISIBLE);
        btn_p3.setVisibility(View.INVISIBLE);
        btn_p4.setVisibility(View.INVISIBLE);
        btn_p5.setVisibility(View.INVISIBLE);

        TX2.setVisibility(View.INVISIBLE);
        TX3.setVisibility(View.INVISIBLE);
        TX4.setVisibility(View.INVISIBLE);
        TX5.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionnaire1Activity.this, FindQuestionnaireActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                Questionnaire1Activity.this.finish();
            }
        });

        btn_n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_n1.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
            }
        });
        btn_n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
            }
        });
        btn_n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);

                TX5.setVisibility(View.VISIBLE);
                ln5.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
            }
        });

        btn_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX5.setVisibility(View.INVISIBLE);
                ln5.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
            }
        });
        btn_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
            }
        });
        btn_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
            }
        });
        btn_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_n1.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
            }
        });


        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton47:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton48:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton49:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton50:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton51:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton53:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton55:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton56:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton57:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton58:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton27:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton21:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton24:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton26:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton25:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton29:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton28:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton30:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton31:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton34:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton39:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton35:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton36:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton38:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton37:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton41:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton40:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton42:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton45:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton46:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton15:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton11:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton12:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton16:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton13:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton17:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton14:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton18:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton19:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton20:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton1:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton2:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton3:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton4:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton5:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton6:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton7:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton8:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton9:
                        radioButton_string = "1";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton_string == null || radioButton_string5 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null) {
                    Toast.makeText(Questionnaire1Activity.this, "Invalid input!!!!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    in1 = Integer.parseInt(radioButton_string2);
                    in2 = Integer.parseInt(radioButton_string3);
                    in3 = Integer.parseInt(radioButton_string4);
                    in4 = Integer.parseInt(radioButton_string5);
                    in5 = Integer.parseInt(radioButton_string);
                    sum = in1 + in2 + in3 + in4 + in5;
                    if (sum >= 0 && sum <= 20) {
                        tx1.setVisibility(View.VISIBLE);
                        tx2.setVisibility(View.VISIBLE);
                        tx3.setVisibility(View.VISIBLE);
                    } else if (sum >= 21 && sum <= 40) {
                        tx4.setVisibility(View.VISIBLE);
                        tx5.setVisibility(View.VISIBLE);
                        tx6.setVisibility(View.VISIBLE);
                    } else if (sum >= 41) {
                        tx7.setVisibility(View.VISIBLE);
                        tx8.setVisibility(View.VISIBLE);
                        tx9.setVisibility(View.VISIBLE);
                    }

                    questionnaireOne(radioButton_string,
                            radioButton_string5,
                            radioButton_string4,
                            radioButton_string3,
                            radioButton_string2,
                            sum,
                            json_user_id);
                }
            }
        });
    }

    private void questionnaireOne(String radioButton_string, String radioButton_string5, String radioButton_string4, String radioButton_string3, String radioButton_string2, Integer sum, String json_user_id) {
        if (radioButton_string == null || radioButton_string5 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null || sum == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Questionnaire1Request request = new Questionnaire1Request(radioButton_string, radioButton_string2, radioButton_string4, radioButton_string3, radioButton_string5, sum, json_user_id);
        api.questionnaireOne(request).enqueue(new Callback<Questionnaire1Response>() {
            @Override
            public void onResponse(Call<Questionnaire1Response> call, Response<Questionnaire1Response> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(Questionnaire1Activity.this, "Send complete", Toast.LENGTH_LONG).show();
                } else {
                    //error
                    Toast.makeText(Questionnaire1Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Questionnaire1Response> call, Throwable t) {
                Toast.makeText(Questionnaire1Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
