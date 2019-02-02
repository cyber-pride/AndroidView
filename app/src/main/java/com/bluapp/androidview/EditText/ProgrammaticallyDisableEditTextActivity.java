package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class ProgrammaticallyDisableEditTextActivity extends AppCompatActivity {
    private EditText disableEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_disable_edit_text);
        disableEdittext = (EditText) findViewById(R.id.disableEdittext);
        disableEdittext.setFocusable(false);
        disableEdittext.setEnabled(false);

    }
}
