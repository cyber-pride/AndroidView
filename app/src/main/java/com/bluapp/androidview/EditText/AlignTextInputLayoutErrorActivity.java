package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.CustomTextInputLayout;
import com.bluapp.androidview.R;

public class AlignTextInputLayoutErrorActivity extends AppCompatActivity {
    private CustomTextInputLayout textinputlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align_text_input_layout_error);
        textinputlayout = (CustomTextInputLayout) findViewById(R.id.textinputlayout);
        textinputlayout.setErrorEnabled(true);

        textinputlayout.setError("Empty field");
    }
}
