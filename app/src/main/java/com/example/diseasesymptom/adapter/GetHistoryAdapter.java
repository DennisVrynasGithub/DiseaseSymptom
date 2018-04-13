package com.example.diseasesymptom.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.DeleteHistoryResponse;
import com.example.diseasesymptom.model.GetHistoryResponse;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetHistoryAdapter extends ArrayAdapter {
    private List list = new ArrayList();
    static Context c;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public GetHistoryAdapter(Context context, int resource) {
        super(context, resource);

        this.c = context;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        final GetHistoryAdapter.PlayerHolder playerHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_layout_history, parent, false);
            playerHolder = new GetHistoryAdapter.PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.textView98);
            playerHolder.column2 = row.findViewById(R.id.textView99);
            playerHolder.column3 = row.findViewById(R.id.textView100);
            playerHolder.btnDeleteHistory = row.findViewById(R.id.btnDeleteHistory);
            row.setTag(playerHolder);
        } else {
            playerHolder = (GetHistoryAdapter.PlayerHolder) row.getTag();
        }
        final GetHistoryResponse players = (GetHistoryResponse) this.getItem(position);
        assert players != null;
        playerHolder.column1.setText((players.getName()));
        playerHolder.column2.setText((players.getDate()));
        playerHolder.column3.setText((players.getId()));
        playerHolder.btnDeleteHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteHistory(playerHolder.user_id, players.getId());
            }
        });
        return row;
    }

    private static class PlayerHolder {
        TextView column1, column2, column3;
        Button btnDeleteHistory;

        SharedPreferences prefs = c.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String user_id = prefs.getString("user_id_sp", null);
    }


    private void deleteHistory(String user_id, String disease_id) {

        Api api;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
        Integer a = Integer.parseInt(user_id);
        Integer b = Integer.parseInt(disease_id);
        Call<DeleteHistoryResponse> jsonCall = api.deleteHistory(a, b);
        jsonCall.enqueue(new Callback<DeleteHistoryResponse>() {
            @Override
            public void onResponse(Call<DeleteHistoryResponse> call, Response<DeleteHistoryResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(c, "Delete success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(c, "Delete failed!", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<DeleteHistoryResponse> call, Throwable t) {
                Log.e("onFailure", t.toString());
                Toast.makeText(c, "FAILED!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
