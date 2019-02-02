package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class GetEditTextIntActivity extends AppCompatActivity {
    private EditText getint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_edit_text_int);
        getint = (EditText) findViewById(R.id.getint);
    }

    public void intValue(View view){
        int value = Integer.parseInt(getint.getText().toString());
        Toast.makeText(GetEditTextIntActivity.this, "Value "+String.valueOf(value), Toast.LENGTH_SHORT).show();
    }
}
