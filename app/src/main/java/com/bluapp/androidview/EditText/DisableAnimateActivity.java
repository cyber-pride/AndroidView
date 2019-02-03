package com.bluapp.androidview.EditText;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class DisableAnimateActivity extends AppCompatActivity {
    private TextInputLayout textInputEditText;
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_animate);
        textInputEditText = (TextInputLayout) findViewById(R.id.fullnameLayout);
        fullname = (EditText) findViewById(R.id.fullname);
        textInputEditText.setHintAnimationEnabled(false);
        textInputEditText.setHint("");
        fullname.setHint("Fullname");
    }
}
