package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class EmptyEditTextCheckActivity extends AppCompatActivity {
    private EditText fullname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_edit_text_check);
        fullname = (EditText) findViewById(R.id.fullname);
    }

    public void isEmpty(View view){
        String fullnamestr = fullname.getText().toString();
        if(fullnamestr.equals("")){
            fullname.setError("Field is empty");
        }
    }
}
