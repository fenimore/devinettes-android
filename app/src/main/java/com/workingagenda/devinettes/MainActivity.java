package com.workingagenda.devinettes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Riddle> riddles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        riddles = RiddleCollection.Collect();
        loadScoreData();
        mListView = (ListView) findViewById(android.R.id.list);
        RiddleAdapter adapter = new RiddleAdapter(this, R.layout.row_riddle, riddles);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(getBaseContext(), RiddlePanel.class);
                intent.putExtra("riddle", riddles.get(pos));
                startActivityForResult(intent, 0);
                //finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_score) {
            return true;
        }else if (id == R.id.action_about) {
            return true;
        } else if (id == R.id.action_reset) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadScoreData() {
        SharedPreferences score;
        score = getSharedPreferences("score", Context.MODE_PRIVATE);
        for (int i=0; i<riddles.size(); i++) {
            riddles.get(i).setCorrect(score.getBoolean(Integer.toString(i), false));
            Log.d(Integer.toString(riddles.get(i).getId()), String.valueOf(riddles.get(i).isCorrect()) );
        }

    }
}
