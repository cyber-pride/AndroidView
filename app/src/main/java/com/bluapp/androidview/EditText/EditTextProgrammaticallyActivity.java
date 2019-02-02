package com.bluapp.androidview.EditText;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class EditTextProgrammaticallyActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_programmatically);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        EditText edittext = new EditText(this);
        RelativeLayout.LayoutParams rel = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rel.setMargins(15, 15, 15, 15);
        rel.addRule(RelativeLayout.CENTER_IN_PARENT);
        edittext.setLayoutParams(rel);
        edittext.setBackground(getResources().getDrawable(R.drawable.edit_text));
        edittext.setTextColor(Color.parseColor("#000000"));
        edittext.setHintTextColor(Color.parseColor("#848484"));
        edittext.setTextSize(24);
        edittext.setHint("Fullname");
        edittext.setPadding(10, 6, 10, 6);
        edittext.setInputType(InputType.TYPE_CLASS_TEXT);
        relativeLayout.addView(edittext);
    }
}
