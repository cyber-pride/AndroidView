package com.bluapp.androidview.Fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData message = new MutableLiveData();

    public void setMessage(String msg) {
        message.setValue(msg);
    }

    public MutableLiveData getMessage() {
        return message;
    }
}