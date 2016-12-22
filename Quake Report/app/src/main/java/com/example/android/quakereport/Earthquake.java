package com.example.android.quakereport;

/**
 * Created by megam on 2016-12-19.
 */

public class Earthquake {
    //Magnitude of earthquake
    private String mMag;

    //Location of earthquake
    private String mLoc;

    private String mNear;

    //Date of earthquake
    private String mDate;

    private String mTime;

    private String mUrl;

    public Earthquake (String magnitude, String near, String location, String time, String date, String url){
        mMag = magnitude;
        mLoc = location;
        mTime = time;
        mDate = date;
        mNear = near;
        mUrl = url;
    }

    public String getMagnitude(){
        return mMag;
    }

    public String getNear() { return mNear;}

    public String getLocation(){
        return mLoc;
    }

    public String getTime() { return mTime;}

    public String getDate(){
        return mDate;
    }

    public String getUrl() { return mUrl; }
}
