package com.bluapp.androidview.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.R;

public class RefreshBtnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_btn);
    }

    public void refreshActivity(View view){
        Intent refresh = getIntent();
        finish();
        startActivity(refresh);
    }
}
