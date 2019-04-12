package com.bluapp.androidview.Menu;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;

import com.bluapp.androidview.R;

public class MenuActivity20 extends AppCompatActivity implements View.OnCreateContextMenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu20);
    }

    public void contexMenu(View view){
        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
       super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, contextMenu);
    }
}
