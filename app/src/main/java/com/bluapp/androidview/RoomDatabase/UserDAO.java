package com.bluapp.androidview.RoomDatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDAO {
    @Query("select * from users")
    List<User> getuserList();

    @Query("SELECT * FROM users WHERE id = :id")
    public User getItemById(int id);

    @Insert
    public void insert(User user);

    @Insert
    public void insert(Profile profile);

    @Update
    public void update(User user);

    @Delete
    public void delete(User user);

    @Query("select * from users limit 1")
    List<User> getlimituserList();

    @Query("select * from users")
    LiveData<List<User>> getuserliveList();

    @Query("select * from users")
    Single<List<User>> getusersingleList();

    @Query("select * from users")
    List<UserWithProfile> getuseronerelation();
}