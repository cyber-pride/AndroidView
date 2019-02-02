package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class ValidateEditTextActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_edit_text);
        fullname = (EditText) findViewById(R.id.fullname);
    }

    public void validate(View view){
        String fullnamestr = fullname.getText().toString();
        if(fullnamestr.equals("")){
            fullname.setError("Field is empty");
        }else if(fullnamestr.length()<=2){
            fullname.setError("Name must be more than 2");
        } else{
            Toast.makeText(ValidateEditTextActivity.this, fullnamestr, Toast.LENGTH_LONG).show();
        }
    }
}
