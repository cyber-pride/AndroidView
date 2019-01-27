package com.bluapp.androidview.Button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

public class ProgrammaticallyFabActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_fab);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        FloatingActionButton fab = new FloatingActionButton(this);
        RelativeLayout.LayoutParams rel = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rel.setMargins(15, 15, 15, 15);
        rel.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rel.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        fab.setLayoutParams(rel);
        fab.setImageResource(android.R.drawable.ic_dialog_email);
        fab.setSize(FloatingActionButton.SIZE_NORMAL);
        relativeLayout.addView(fab);
    }
}
