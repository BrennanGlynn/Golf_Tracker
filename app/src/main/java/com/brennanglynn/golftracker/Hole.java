package com.brennanglynn.golftracker;

public class Hole {
    private int mHoleNumber;
    private int mHoleScore;

    public Hole(int mHoleNumber) {
        this.mHoleNumber = mHoleNumber;
    }

    public int getmHoleNumber() {
        return mHoleNumber;
    }

    public void setmHoleNumber(int mHoleNumber) {
        this.mHoleNumber = mHoleNumber;
    }

    public int getmHoleScore() {
        return mHoleScore;
    }

    public void setmHoleScore(int mHoleScore) {
        this.mHoleScore = mHoleScore;
    }
}
