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
import com.example.diseasesymptom.model.Players;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 8/1/2018.
 */

public class PlayerAdapter extends ArrayAdapter {

    private List list = new ArrayList();

    public PlayerAdapter(Context context, int resource) {
        super(context, resource);
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
        PlayerHolder playerHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_layout, parent, false);
            playerHolder = new PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.tx_disease_id);
            playerHolder.column2 = row.findViewById(R.id.tx_disease_a2z);
            playerHolder.column3 = row.findViewById(R.id.tx_diseasename);
            playerHolder.column4 = row.findViewById(R.id.tx_disease_fact);
            playerHolder.column5 = row.findViewById(R.id.tx_disease_description);
            row.setTag(playerHolder);
        } else {
            playerHolder = (PlayerHolder) row.getTag();
        }
        Players players = (Players) this.getItem(position);
        assert players != null;
        playerHolder.column1.setText((players.getId()));
        playerHolder.column2.setText((players.getA2z()));
        playerHolder.column3.setText((players.getName()));
        playerHolder.column4.setText((players.getFact()));
        playerHolder.column5.setText((players.getDescription()));
        return row;
    }

    private static class PlayerHolder {
        TextView column1, column2, column3, column4, column5;
    }
}
