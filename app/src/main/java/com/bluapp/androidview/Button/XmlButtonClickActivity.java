package com.bluapp.androidview.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.R;

public class XmlButtonClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_button_click);
    }

    public void startActivity(View view){
        startActivity(new Intent(XmlButtonClickActivity.this, MainActivity.class));
    }
}
