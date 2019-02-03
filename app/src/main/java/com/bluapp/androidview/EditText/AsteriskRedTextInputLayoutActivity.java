package com.bluapp.androidview.EditText;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.R;

public class AsteriskRedTextInputLayoutActivity extends AppCompatActivity {
    private TextInputLayout textinputlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asterisk_red_text_input_layout);
        textinputlayout = (TextInputLayout) findViewById(R.id.textinputlayout);
        textinputlayout.setHint(textinputlayout.getHint()+" "+getString(R.string.asteriskred));
    }
}
