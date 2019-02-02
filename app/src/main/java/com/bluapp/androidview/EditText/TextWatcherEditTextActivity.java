package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.bluapp.androidview.R;

public class TextWatcherEditTextActivity extends AppCompatActivity {
    private EditText fullname;
    private TextView txtfullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_watcher_edit_text);
        fullname = (EditText) findViewById(R.id.fullname);
        txtfullname = (TextView) findViewById(R.id.txtfullname);

        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            txtfullname.setText(fullname.getText());
            }
        });
    }
}
