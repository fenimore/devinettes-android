/*
 *
 *   Copyright (C) 2014-2015 Fenimore Love
 *
 *   The riddles may not be delivered commercially, that is - no one
 *   other than the riddlers may sell the answers to the riddles.
 *    *
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
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by fenimore on 1/7/15.
 * TODO: make the magnification toggle
 * list stuff
 */
public class riddlePanel extends Activity {

    /**
     * Outside of the oncreate method there are
     * simply the methods for: CheckAnswer and Load/Save Score
     *
     * The oncreate fills the riddle TextView and then
     * populates, likewise, the answer field
     *
     * TODO: Button for submit? Scroll somehow?
     *
     */

    private static final int ACTIVITY_LIST=0;

    //The arrays
    private String[] mRiddles;
    private String[] answers;
    private String[] answersTwo;

    //The score
    public int count = 0;

    //The different Views are declared here
    TextView words;
    EditText input;
    Button btnGuess;
    ImageButton btnEnlarge;

    //Truth array and shared preferences is for tracking the score
    public boolean truthArray[] = new boolean[16];
    public static final String Preferences = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.riddle_panel);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        words = (TextView) findViewById(R.id.words);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        btnEnlarge = (ImageButton) findViewById(R.id.btnEnlarge);
        input = (EditText) findViewById(R.id.userInput);

        mRiddles = getResources().getStringArray(R.array.riddles);

        //Receive intent which is the key for the Riddle answer, and text and truth check
        Bundle extras = getIntent().getExtras();
        final int key = extras.getInt("key");
        words.setText(mRiddles[key]);

        Typeface Dejatf = Typeface.createFromAsset(getAssets(),"fonts/DejaVuSansCondensed.ttf");
        words.setTypeface(Dejatf);
        btnGuess.setTypeface(Dejatf);
        //btnEnlarge.setTypeface(tf);

        loadScoreData();

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = input.getText().toString();
                guess.toLowerCase();
                answers = getResources().getStringArray(R.array.answers);
                //answersTwo = getResources().getStringArray(R.array.answersTwo);
                String ans = answers[key];
                //String ans2 = answersTwo[key];
                guess = createHash(guess);
                checkAnswer(guess, ans, key);
            }
        });
        btnEnlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                words.setTextSize(21);
            }
        });
        words.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(truthArray[key]){
                    words.setText("This riddle has been solved");
                }
                return true;
            }
        });
    }
    /**
     * This checks the answer
     * @param guess
     * @param ans
     */
    public void checkAnswer(String guess, String ans, int key){
        // if the hash guess agrees with the stored hash, toash congrats and
        // set score ++
        if(guess.equals(ans)){
            Toast reply = Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT);
            reply.show();
            input.setText("");
            truthArray[key] = true;
        }
        else{
            Toast reply = Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT);
            reply.show();
        }
    }
    /**
     * Load and Save the score data
     */
    public void loadScoreData() {
        SharedPreferences savedScore = getSharedPreferences(Preferences, Context.MODE_PRIVATE);
        for(int i = 0; i<16; i++){
            String keyX = "nameKey" + i;
            truthArray[i] = savedScore.getBoolean(keyX, false);
        }
    }
    private void saveData(){
        SharedPreferences savedScore;
        savedScore = getSharedPreferences(Preferences, 0);
        SharedPreferences.Editor editor = savedScore.edit();
        for(int i = 0; i<16; i++){
            String keyX = "nameKey" + i;
            editor.putBoolean(keyX, truthArray[i]);
        }
        editor.commit();
    }

    /**
     * Options Menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.riddle_panel, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // TODO: figure out how to use the up
        int id = item.getItemId();
        if (id == R.id.action_back) {
            saveData();
            Intent intent = new Intent(this, riddleList.class);
            intent.putExtra("counter", count);
            startActivityForResult(intent, ACTIVITY_LIST);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private String createHash(String input){
        /*
        This method is from
        https://github.com/dillbyrne/HashPass/
        blob/master/src/byrne/utilities/hashpass/HashPassActivity.java
        This will take in the guess and spit out the hash
         */

        byte[] bytesOfMessage;

        try {
            bytesOfMessage = input.getBytes("UTF-8");
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA1");
                byte[] thedigest = md.digest(bytesOfMessage);
                final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
                //I think this is the encryption part
                StringBuilder sb = new StringBuilder(thedigest.length * 2);
                for (byte b : thedigest) {
                    sb.append(HEX_CHARS[(b & 0xF0) >> 4]);
                    sb.append(HEX_CHARS[b & 0x0F]);
                }
                return sb.toString();
                //should not occur due to limited input choices
                // and no null options available
            } catch (NoSuchAlgorithmException nsae) {
                nsae.printStackTrace();
            }
            //should not occur due to hard coded encoding choice
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        // returns null if it was unable to perform the hashing
        return null;
    }

}
