package com.bluapp.androidview.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RepoDao {

    @Insert
    void insert(Repo repo);

    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);

    @Query("SELECT * FROM repo")
    List<Repo> getAllRepos();

    @Query("SELECT * FROM repo WHERE userId=:userId")
    List<Repo> findRepositoriesForUser(final int userId);
}