package com.bluapp.androidview;


public class Video {
    private String userName, Place, Time;

    public Video(String userName, String Place, String Time) {
        this.userName = userName;
        this.Place = Place;
        this.Time = Time;
    }

    public String getuserName() {
        return userName;
    }

    public String getPlace() {
        return Place;
    }

    public String getTime() {
        return Time;
    }
}
