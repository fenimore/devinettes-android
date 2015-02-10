package com.workingagenda.another.devinettes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fen on 2/10/15.
 *
 *
 *
 */
public class riddleAdapter extends ArrayAdapter<String> {
    private boolean[] truthCheck;

    public riddleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public riddleAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        v = vi.inflate(R.layout.list_row, null);

        TextView tt = (TextView) v.findViewById(R.id.rowTextView);
        if(truthCheck[position]){
            tt.setBackgroundResource(R.color.gold);
            tt.setTextColor(Color.BLACK);
        }

        String p = getItem(position);
        if (p != null) {
            if (tt != null) {
                tt.setText(p.toString());
            }
        }
        return v;
    }
    public void setTruthCheck(boolean[] truthCheck) {
        this.truthCheck = truthCheck;
    }
}