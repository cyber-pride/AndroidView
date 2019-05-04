package com.bluapp.androidview.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    public final LiveData<List<User>> itemusers;
    public UserDatabase userDatabase;
    public UserViewModel(Application application){
        super(application);
        userDatabase = UserDatabase.getInstance(this.getApplication());
        itemusers = userDatabase.userDAO().getuserliveList();
    }

    public LiveData<List<User>> getItemusers(){
        return itemusers;
    }

}