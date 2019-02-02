package com.bluapp.androidview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.Button.ButtonActivity;
import com.bluapp.androidview.EditText.EditTextActivity;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void Button(View view){
        startActivity(new Intent(ViewActivity.this, ButtonActivity.class));
    }

    public void EditText(View view){
        startActivity(new Intent(ViewActivity.this, EditTextActivity.class));
    }
}
