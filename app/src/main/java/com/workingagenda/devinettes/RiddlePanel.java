package com.workingagenda.devinettes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private Button btn;
    private EditText et;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Riddle r = i.getParcelableExtra("riddle");

        tv = (TextView) findViewById(R.id.riddle);
        et = (EditText) findViewById(R.id.guess);
        tv.setText(r.getRiddle());
        btn = (Button) findViewById(R.id.btnGuess);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = et.getText().toString().toLowerCase();
                guess = createHash(guess);
                if(guess.equals(r.getAnswer())){
                    Toast.makeText(RiddlePanel.this, "", Toast.LENGTH_SHORT).show();
                    Toast reply = Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT);
                    reply.show();
                    et.setText("");
                }
            }

        });

    }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
