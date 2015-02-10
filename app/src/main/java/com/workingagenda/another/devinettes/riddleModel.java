package com.workingagenda.another.devinettes;

/**
 * Created by fen on 2/10/15.
 */
public class riddleModel {
    private int position;
    public boolean truthCounter;

    public riddleModel(int position, boolean truthCounter) {
        this.position = position;
        this.truthCounter = truthCounter;
    }

    public boolean isTruthCounter() {
        return truthCounter;
    }

    public void setTruthCounter(boolean truthCounter) {
        this.truthCounter = truthCounter;
    }
}