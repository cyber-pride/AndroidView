package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class EditTextGetInputValueActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_get_input_value);
        fullname = (EditText) findViewById(R.id.fullname);
    }

    public void EditTextValue(View view){
        String strFullname = fullname.getText().toString();
        Toast.makeText(EditTextGetInputValueActivity.this, "value "+strFullname, Toast.LENGTH_LONG).show();
    }
}
