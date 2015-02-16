/*
 *
 *   Copyright (C) 2014-2015 Fenimore Love
 *
 *   The riddles may not be delivered commercially, that is - noone
 *   other than the riddlers may sell the answers to these riddles.
 *
 *   This program is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.
 *   This program is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.workingagenda.another.devinettes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class riddleList extends Activity {

    private static final int ACTIVITY_LOAD=0;

    private ListView rListView ;
    String[] riddleTitles;
    public boolean[] truthArray = new boolean[18];
    private final static String Preferences = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle_list);

        final TextView creditsPanel = (TextView) findViewById(R.id.creditsPanel);
        loadScoreData();
        fillList();

        Typeface Dejatf = Typeface.createFromAsset(getAssets(),"fonts/DejaVuSansCondensed.ttf");
        creditsPanel.setTypeface(Dejatf);

        /**
         * The clicking Listeners
         */
        rListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] credits = getResources().getStringArray(R.array.credits);
                String author = credits[i];
                creditsPanel.setText(author);
                if(truthArray[i]){
                    creditsPanel.append(" -- solved");
                }
                return true;
            }
        });

        rListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;

                loadRiddle(position);
            }
        });
    }

    /**
     * Load riddle
     * this is called when a list item is clicked, it Starts Activity
     * @param position
     */
    private void loadRiddle(int position) {
        Intent intent = new Intent(this, riddlePanel.class);
        intent.putExtra("key", position);
        startActivityForResult(intent, ACTIVITY_LOAD);
        finish();
    }

    /**
     * this method fills the list, it is basically the array adapter
     * TODO: replace this with a custom adapter?
     */
    public void fillList() {

        riddleTitles = getResources().getStringArray(R.array.riddleTitles);
        rListView = (ListView) findViewById(R.id.listView);
        ArrayList<String> riddleList = new ArrayList<String>();
        riddleList.addAll(Arrays.asList(riddleTitles));
        riddleAdapter customAdapter = new riddleAdapter(this, R.layout.list_row, riddleList);
        customAdapter.setTruthCheck(truthArray);
        rListView.setAdapter(customAdapter);


    }

    /**
     * Resets the score by flooding the Truth Array with false
     */
    private void resetScore() {
        Arrays.fill(truthArray, false);
        //Falsify and then save, but without a separate function
        SharedPreferences savedScore;
        savedScore = getSharedPreferences(Preferences, 0);
        SharedPreferences.Editor editor = savedScore.edit();
        for(int i = 0; i<18; i++){
            String keyX = "nameKey" + i;
            editor.putBoolean(keyX, truthArray[i]);
        }
        editor.commit();
    }

    /**
     * Loads the score data, this should be used to check the score AND
     *
     */
    public void loadScoreData() {
        SharedPreferences savedScore = getSharedPreferences(Preferences, Context.MODE_PRIVATE);
        for(int i = 0; i<18; i++){
            String keyX = "nameKey" + i;
            truthArray[i] = savedScore.getBoolean(keyX, false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.riddle_list, menu);
        return true;
    }

    /**
     * This selects the Menu items, these are the main actions for the user
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_question) {
            String d = getResources().getString(R.string.help_text);
            final SpannableString s = new SpannableString(d);
            Linkify.addLinks(s, Linkify.EMAIL_ADDRESSES);

            AlertDialog helpDialog = new AlertDialog.Builder(
                    riddleList.this).create();

            // Setting Dialog Title
            helpDialog.setTitle("Questions?");
            helpDialog.setMessage(s);
            helpDialog.setIcon(R.drawable.sphinx_25);
            helpDialog.setButton("back-to-the-riddles-please", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write code here to execute after dialog closed
                }
            });
            helpDialog.show();
            return true;
        }
        if (id == R.id.action_score) {
            int score = 0;
            for (int i = 0; i < 18; i++) {
                if (truthArray[i]) {
                    score++;
                }
            }
            Toast scoreDisplay = Toast.makeText(this, "you've solved " + score, Toast.LENGTH_SHORT);
            scoreDisplay.show();

            return true;
        }
        if (id == R.id.action_reset){
            resetScore();
            fillList();
            Toast reset = Toast.makeText(this, "your score has been reset", Toast.LENGTH_SHORT);
            reset.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
