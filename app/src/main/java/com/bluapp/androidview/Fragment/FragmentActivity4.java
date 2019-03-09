package com.bluapp.androidview.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.R;

public class FragmentActivity4 extends AppCompatActivity {
    protected OnBackPressedListner onBackPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment4);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new Fragment4()).commit();
    }


    @Override
    public void onBackPressed(){
       Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame);
       if(!(fragment instanceof  OnBackPressedListner)|| !((OnBackPressedListner)fragment).onBackPressed()){
           super.onBackPressed();
       }
    }

    public interface OnBackPressedListner{
        boolean onBackPressed();
    }

}
