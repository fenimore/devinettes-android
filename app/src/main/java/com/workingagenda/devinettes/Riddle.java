package com.workingagenda.devinettes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by fen on 8/10/16.
 */
public class Riddle implements Parcelable {

    private String title;
    private String riddle;
    // TODO: change to List<>
    private String answer;
    private boolean correct;
    private String author;
    private int id;

    public Riddle(String title, String riddle, String author, String answer) {
        this.title = title;
        this.riddle = riddle;
        this.answer = answer;
        this.correct = false;
    }



    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answers) {
        this.answer = answer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(riddle);
        parcel.writeString(answer);
        parcel.writeString(author);
    }

     public static final Parcelable.Creator<Riddle> CREATOR
             = new Parcelable.Creator<Riddle>() {
         public Riddle createFromParcel(Parcel in) {
             return new Riddle(in);
         }

         public Riddle[] newArray(int size) {
             return new Riddle[size];
         }
     };

    private Riddle(Parcel in) {
        title = in.readString();
        riddle = in.readString();
        answer = in.readString();
        author = in.readString();
    }


}
