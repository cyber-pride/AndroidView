package com.bluapp.androidview.RoomDatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

@Database(entities = { User.class, Repo.class, Profile.class, UserRepoJoin.class }, version = 2, exportSchema = false)
@TypeConverters(TypeConverter13.class)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME ="UserDb";
    private static UserDatabase instance;
    public abstract UserDAO userDAO();
    public abstract RepoDao getRepoDao();
    public abstract UserRepoJoinDao getUserRepoJoinDao();
    private static final Migration MIGRATION_1_2 =new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 'name' TEXT NOT NULL)");
        }
    };


    public synchronized static UserDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDatabase.class, DB_NAME)
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    RoomDatabaseActivity9.runDb(context, getInstance(context));
                                }
                            });
                        }
                    })
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
}