package com.bluapp.androidview.RoomDatabase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = CASCADE))
public class Repo {
    @PrimaryKey
    public final int id;
    public final String name;
    public final String url;
    public final int userId;

    public Repo(final int id, String name, String url, final int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }
}