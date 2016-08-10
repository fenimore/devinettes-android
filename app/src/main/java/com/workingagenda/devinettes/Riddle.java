package com.workingagenda.devinettes;

import java.util.ArrayList;

/**
 * Created by fen on 8/10/16.
 */
public class Riddle {

    private String title;
    private String riddle;
    private String answer;
    private boolean correct;
    private String author;

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




}
