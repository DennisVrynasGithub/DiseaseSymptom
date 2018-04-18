package com.example.diseasesymptom.listView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.adapter.PlayerAdapter;
import com.example.diseasesymptom.model.AddHistoryRequest;
import com.example.diseasesymptom.model.AddHistoryResponse;
import com.example.diseasesymptom.model.Players;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayListView extends AppCompatActivity {

    String Json_string, user_id, id, name, a2z, fact, description;
    JSONObject jsonObject;
    JSONArray jsonArray;
    PlayerAdapter playerAdapter;
    ListView listView;
    TextView txHeader;
    Button button_add_history_disease;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        //Receive Json
        Json_string = getIntent().getExtras().getString("Json_data");
        user_id = getIntent().getExtras().getString("json_user_id");
        listView = findViewById(R.id.listview);
        txHeader = findViewById(R.id.textView82);
        button_add_history_disease = findViewById(R.id.button3);
        playerAdapter = new PlayerAdapter(this, R.layout.activity_row_layout);
        listView.setAdapter(playerAdapter);

        user_id = prefs.getString("user_id_sp", null);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        try {
            // Transform json to json object
            jsonObject = new JSONObject(Json_string);
            // Create array with name disease
            jsonArray = jsonObject.getJSONArray("disease");
            int count = 0;
            while (count < jsonArray.length()) {
                // Put id , name and a2z into array
                JSONObject JO = jsonArray.getJSONObject(count);
                id = JO.getString("id");
                name = JO.getString("name");
                a2z = JO.getString("a2z");
                fact = JO.getString("fact");
                description = JO.getString("description");
                txHeader.setText(name);
                Players players = new Players(id, a2z, name, fact, description);
                playerAdapter.add(players);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        button_add_history_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHistory(user_id, id);
            }
        });
    }


    private void addHistory(String user_id, String disease_id) {
        if (user_id == null || disease_id == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        AddHistoryRequest request = new AddHistoryRequest(user_id, disease_id);
        api.addHistory(request).enqueue(new Callback<AddHistoryResponse>() {
            @Override
            public void onResponse(Call<AddHistoryResponse> call, Response<AddHistoryResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(DisplayListView.this, "Add success!", Toast.LENGTH_LONG).show();
                } else {
                    //error
                    Toast.makeText(DisplayListView.this, "Add failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AddHistoryResponse> call, Throwable t) {
                Toast.makeText(DisplayListView.this, "Add failed!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
