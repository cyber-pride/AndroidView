package com.bluapp.androidview.RoomDatabase;


import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithProfile {
    @Embedded
    public User user;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public List<Profile> profiles;
}
