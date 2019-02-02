package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class ProgrammaticallyInputTypeActivity extends AppCompatActivity {
    private EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_input_type);
        phone = (EditText) findViewById(R.id.phone);
        phone.setInputType(InputType.TYPE_CLASS_PHONE);
    }
}
