package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.bluapp.androidview.R;

public class EditTextCursorOnEndActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_cursor_on_end);
        fullname = (EditText) findViewById(R.id.fullname);
        fullname.setText("Inducesmile");
        fullname.setSelection(fullname.length());
    }
}
