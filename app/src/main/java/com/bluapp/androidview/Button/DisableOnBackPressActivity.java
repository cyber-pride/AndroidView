package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.R;

public class DisableOnBackPressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_on_back_press);
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }
}
