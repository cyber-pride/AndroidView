package com.bluapp.androidview.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "profile")
public class Profile {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "userId")
    private int userId;
    @ColumnInfo(name = "country")
    private String country;
    public Profile(int id, String country){
        this.id = id;
        this.country = country;
    }
    @Ignore
    public Profile(String country){
        this.country = country;
    }
    public int getId() {
        return id;
    }
    public String getCountry() {
        return country;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}