package com.bluapp.androidview.RoomDatabase;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "user_repo_join",
        primaryKeys = { "userId", "repoId" },
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId"),
                @ForeignKey(entity = Repo.class,
                        parentColumns = "id",
                        childColumns = "repoId")
        })
public class UserRepoJoin {
    public final int userId;
    public final int repoId;

    public UserRepoJoin(final int userId, final int repoId) {
        this.userId = userId;
        this.repoId = repoId;
    }
}