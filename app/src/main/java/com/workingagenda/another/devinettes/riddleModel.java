package com.workingagenda.another.devinettes;

import java.util.ArrayList;

/**
 * Created by fen on 2/10/15.
 */
public class riddleModel {
    private String title;
    public boolean truthCounter;
    riddleList riddles = new riddleList();
    boolean[] truthCount = riddles.returnArray();
    String[] titles = riddles.returnTitles();

    public riddleModel(String title, boolean truthCounter) {
        this.title = title;
        this.truthCounter = truthCounter;
    }

    public boolean isTruthCounter() {
        return truthCounter;
    }

    public void setTruthCounter(boolean truthCounter) {
        this.truthCounter = truthCounter;
    }

    public static ArrayList<riddleModel> getRiddles() {
        ArrayList<riddleModel> riddles = new ArrayList<riddleModel>();
        for (int i=0; i<16; i++){
           // riddles.add(new riddleModel(titles[i], truthCount[i]));
        }
        return riddles;
    }
}