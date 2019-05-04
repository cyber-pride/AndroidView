package com.bluapp.androidview.RoomDatabase;


import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class TypeConverter13 implements Serializable{

    @TypeConverter
    public String fromUserValues(List<User> users){
        if(users==null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>(){}.getType();
        String json = gson.toJson(users, type);
        return json;
    }

    @TypeConverter
    public List<User> tousers(String usersString){
        if(usersString==null){
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>(){}.getType();
        List<User> userList = gson.fromJson(usersString, type);
        return userList;
    }
}
