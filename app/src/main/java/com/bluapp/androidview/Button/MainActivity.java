package com.bluapp.androidview.Button;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bluapp.androidview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void closeKeyboard(View v){
        try {
            InputMethodManager editTextInput = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            editTextInput.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e){
            Log.e("AndroidView", "closeKeyboard: "+e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.button_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_textimageButton:
                startActivity(new Intent(MainActivity.this, TextIconButtonActivity.class));
                return true;
            case R.id.action_buttonClicked:
                startActivity(new Intent(MainActivity.this, StartActivityButtonActivity.class));
                return true;
        }

        return true;
    }

}
