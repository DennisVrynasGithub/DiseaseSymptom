package com.example.diseasesymptom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.Results_Q;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 8/3/2018.
 */

public class Result_Q6 extends ArrayAdapter {
    private List list = new ArrayList();
    private Context c;

    public Result_Q6(Context context, int resource) {
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
        final Result_Q6.PlayerHolder playerHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_q2, parent, false);
            playerHolder = new Result_Q6.PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.tx_q2_id_2);
            playerHolder.column2 = row.findViewById(R.id.tx_q2_Date);
            playerHolder.column3 = row.findViewById(R.id.tx_q2_Score);
            row.setTag(playerHolder);
        } else {
            playerHolder = (Result_Q6.PlayerHolder) row.getTag();
        }
        final Results_Q symptoms = (Results_Q) this.getItem(position);
        assert symptoms != null;
        playerHolder.column1.setText((symptoms.getId()));
        playerHolder.column2.setText((symptoms.getDate()));
        playerHolder.column3.setText((symptoms.getScore()));
        return row;
    }

    private static class PlayerHolder {
        TextView column1, column2, column3;
    }
}
