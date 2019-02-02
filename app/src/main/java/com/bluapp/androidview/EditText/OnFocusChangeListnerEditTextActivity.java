package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class OnFocusChangeListnerEditTextActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_focus_change_listner_edit_text);
        fullname = (EditText) findViewById(R.id.fullname);

        fullname.setFocusable(true);

        fullname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasfocus) {
                    if(hasfocus){
                        if(fullname.getText().toString().equals("")){
                            fullname.setError("Empty Field");
                        }else{
                            Toast.makeText(OnFocusChangeListnerEditTextActivity.this, "OnFocusChangeListener", Toast.LENGTH_LONG).show();
                        }
                    }
            }
        });

    }
}
