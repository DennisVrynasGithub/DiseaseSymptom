package com.example.diseasesymptom.listView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.adapter.GetHistoryAdapter;
import com.example.diseasesymptom.model.GetHistoryResponse;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayListHistory extends AppCompatActivity {

    String Json_string, user_id, name, id, date;
    ListView listView;
    GetHistoryAdapter historyAdapter;
    JSONObject jsonObject;
    JSONArray jsonArray;

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_history);

        //Receive Json
        Json_string = getIntent().getExtras().getString("Json_data");
        user_id = getIntent().getExtras().getString("json_user_id");
        listView = findViewById(R.id.listViewHistory);
        historyAdapter = new GetHistoryAdapter(this, R.layout.activity_row_layout_history);
        listView.setAdapter(historyAdapter);

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
                name = JO.getString("name");
                date = JO.getString("date");
                id = JO.getString("id");
                GetHistoryResponse players = new GetHistoryResponse(name, date.substring(0,10), id);
                historyAdapter.add(players);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
