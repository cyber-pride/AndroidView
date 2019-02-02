package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class ClearEditTextActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_edit_text);
        fullname = (EditText) findViewById(R.id.fullname);
    }


    public void ClearEditText(View view){
        fullname.getText().clear();
    }
}
