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
 */
package com.workingagenda.devinettes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fen on 8/10/16.
 */
public class Riddle implements Parcelable {

    private String title;
    private String riddle;
    private List<String> answer;
    private boolean correct;
    private String author;
    private int id;

    public Riddle(String title, String riddle, String author, List<String> answer) {
        this.title = title;
        this.riddle = riddle;
        this.answer = answer;
        this.author = author;
        this.correct = false;
    }



    public List<String> getAnswer() {
        return answer;
    }

    public boolean checkAnswer(String hash) {
        for (String h: this.answer) {
            if (h.equals(h)) {
                return true;
            }
        }
        return false;
    }

    public void setAnswer(List<String> answer) {
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
        parcel.writeStringList(answer);
        parcel.writeString(author);
        parcel.writeInt(id);
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
        in.readStringList(answer);
        author = in.readString();
        id = in.readInt();
    }


}
