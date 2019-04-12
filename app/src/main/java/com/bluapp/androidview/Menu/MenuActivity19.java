package com.bluapp.androidview.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class MenuActivity19 extends AppCompatActivity implements View.OnCreateContextMenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu19);
    }

    public void contexMenu(View view){
        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select The Action!");
        contextMenu.add(0, view.getId(), 0, "Delete");
        contextMenu.add(0, view.getId(), 0, "Edit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Delete"){
            Toast.makeText(MenuActivity19.this, "Delete was pressed", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MenuActivity19.this, "Edit was pressed", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
