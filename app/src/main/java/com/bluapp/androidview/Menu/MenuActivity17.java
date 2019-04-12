package com.bluapp.androidview.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bluapp.androidview.R;

public class MenuActivity17 extends AppCompatActivity {
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu17);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.option_menu17, menu);
        RelativeLayout relativeLayout = (RelativeLayout)menu.findItem(R.id.action_badge).getActionView();
        counter = (TextView) relativeLayout.findViewById(R.id.counter);
        counter.setText("30");
        return true;
    }
}
