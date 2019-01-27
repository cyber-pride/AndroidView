package com.bluapp.androidview.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class OnBackPressTwiceExistActivity extends AppCompatActivity {
    private int k = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_back_press_twice_exist);
    }

    @Override
    public void onBackPressed() {
        k++;
        if(k == 1) {
            Toast.makeText(OnBackPressTwiceExistActivity.this,"Click one more to exist app", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }


    }


}
