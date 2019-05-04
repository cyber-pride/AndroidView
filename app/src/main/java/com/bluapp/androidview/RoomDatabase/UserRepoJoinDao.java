package com.bluapp.androidview.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface UserRepoJoinDao {
    @Insert
    void insert(UserRepoJoin userRepoJoin);

    @Query("SELECT * FROM users INNER JOIN user_repo_join ON users.id=user_repo_join.userId WHERE user_repo_join.repoId=:repoId")
            List<User> getUsersForRepository(final int repoId);

    @Query("SELECT * FROM repo INNER JOIN user_repo_join ON repo.id=user_repo_join.repoId WHERE user_repo_join.userId=:userId")
            List<Repo> getRepositoriesForUsers(final int userId);
}