package com.brennanglynn.golftracker;

import android.os.Parcel;
import android.os.Parcelable;

public class Hole implements Parcelable{
    private int mHoleNumber;
    private int mHoleScore;

    public Hole(int holeNumber, int holeScore) {
        mHoleNumber = holeNumber;
        mHoleScore = holeScore;
    }

    protected Hole(Parcel in) {
        mHoleNumber = in.readInt();
        mHoleScore = in.readInt();
    }

    public static final Creator<Hole> CREATOR = new Creator<Hole>() {
        @Override
        public Hole createFromParcel(Parcel in) {
            return new Hole(in);
        }

        @Override
        public Hole[] newArray(int size) {
            return new Hole[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mHoleNumber);
        parcel.writeInt(mHoleScore);
    }
}
