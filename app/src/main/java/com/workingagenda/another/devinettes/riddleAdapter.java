package com.workingagenda.another.devinettes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by fen on 2/10/15.
 */
public class riddleAdapter extends ArrayAdapter<riddleModel> {
    riddleList riddles = new riddleList();
    public riddleAdapter(Context context, ArrayList<riddleModel> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        riddleModel riddle = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }
        boolean[] bArray = riddles.returnArray();
        int pos = position;
        if(bArray[pos]){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.solved_row, parent, false);
        }

        // Lookup view for data population
        //TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        //tvName.setText(user.name);
        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}