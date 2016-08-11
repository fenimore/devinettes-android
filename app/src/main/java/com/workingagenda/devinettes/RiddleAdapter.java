package com.workingagenda.devinettes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fen on 8/10/16.
 */
public class RiddleAdapter extends ArrayAdapter<Riddle> {


    public RiddleAdapter(Context context, int resource, ArrayList<Riddle> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        convertView = vi.inflate(R.layout.row_riddle, null);

        Riddle r = getItem(position);

        TextView tv = (TextView) convertView.findViewById(R.id.riddle_title);
        tv.setText(r.getTitle());
        try {
            if(r.isCorrect()) {
                tv.setBackgroundResource(R.color.gold);
                tv.setTextColor(Color.BLACK);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Do nothing
        }
        return convertView;
    }
}
