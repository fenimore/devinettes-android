/*
 * Devinettes
 *
 * Copyright (C) 2014 - 2016 Fenimore Love
 *
 * Devinettes is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * Devinettes is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Devinettes; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * Riddles are licensed under
 *     Creative Commons -
 *     Attribution-NonCommercial-NoDerivs 3.0 United States
 */
package com.workingagenda.devinettes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
 * Created by fen on 8/10/16.
 */
public class RiddlePanel extends AppCompatActivity {

    private TextView tv;
    private ImageButton btn;
    private EditText et;
    private Riddle r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        r = i.getParcelableExtra("riddle");
        Log.d("THE ID", Integer.toString(r.getId()));

        tv = (TextView) findViewById(R.id.riddle);
        et = (EditText) findViewById(R.id.guess);
        tv.setText(r.getRiddle());
        btn = (ImageButton) findViewById(R.id.btnGuess);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = et.getText().toString().toLowerCase();
                guess = createHash(guess);
                if (r.checkAnswer(guess)) {
                    Toast.makeText(RiddlePanel.this, "Correct!", Toast.LENGTH_SHORT).show();
                    et.setText("");
                    // Save the Score
                    SharedPreferences score;
                    score = getSharedPreferences("score", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = score.edit();
                    String key = Integer.toString(r.getId()); // Key is ID
                    editor.putBoolean(key, true);
                    editor.commit();
                    Log.d(key, String.valueOf(score.getBoolean(Integer.toString(r.getId()), false)));

                } else {
                    Toast.makeText(RiddlePanel.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //startActivityForResult(new Intent(getBaseContext(), MainActivity.class), 0);
                //finish();
                //NavUtils.shouldUpRecreateTask(this, new Intent(this, MainActivity.class));
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Answers are stored in SHA 1 hash
    // Ha ha source snoopers...
    private String createHash(String g) {
        /*
        This method is from
        https://github.com/dillbyrne/HashPass/
        blob/master/src/byrne/utilities/hashpass/HashPassActivity.java
        This will take in the guess and spit out the hash
         */
        byte[] bytesOfMessage;

        try {
            bytesOfMessage = g.getBytes("UTF-8");
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA1");
                byte[] thedigest = md.digest(bytesOfMessage);
                final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
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
