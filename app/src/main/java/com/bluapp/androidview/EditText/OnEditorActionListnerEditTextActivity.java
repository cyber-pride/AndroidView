package com.bluapp.androidview.EditText;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class OnEditorActionListnerEditTextActivity extends AppCompatActivity {
    private EditText fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_editor_action_listner_edit_text);

        fullname = (EditText) findViewById(R.id.fullname);

        fullname.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                if(i == EditorInfo.IME_ACTION_SEARCH || i == EditorInfo.IME_ACTION_DONE || event != null && event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    if(event == null || !event.isShiftPressed()){
                        Toast.makeText(OnEditorActionListnerEditTextActivity.this, "Done Typing", Toast.LENGTH_LONG).show();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
