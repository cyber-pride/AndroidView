package com.bluapp.androidview.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class FragmentActivity17 extends AppCompatActivity implements Fragment17.sendMessage{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment17);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new Fragment17()).commit();
    }

    @Override
    public void message(String msg){
        Toast.makeText(FragmentActivity17.this,"Result: "+msg,Toast.LENGTH_LONG).show();
    }
}
