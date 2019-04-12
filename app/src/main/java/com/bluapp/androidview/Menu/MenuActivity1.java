package com.bluapp.androidview.Menu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bluapp.androidview.R;

public class MenuActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new Fragment1()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_menu2:
                startActivity(new Intent(MenuActivity1.this, MenuActivity2.class));
                return true;

            case R.id.action_menu3:
                startActivity(new Intent(MenuActivity1.this, MenuActivity3.class));
                return true;

            case R.id.action_menu4:
                startActivity(new Intent(MenuActivity1.this, MenuActivity4.class));
                return true;

            case R.id.action_menu5:
                startActivity(new Intent(MenuActivity1.this, MenuActivity5.class));
                return true;

            case R.id.action_menu6:
                startActivity(new Intent(MenuActivity1.this, MenuActivity6.class));
                return true;

            case R.id.action_menu7:
                startActivity(new Intent(MenuActivity1.this, MenuActivity7.class));
                return true;

            case R.id.action_menu8:
                startActivity(new Intent(MenuActivity1.this, MenuActivity8.class));
                return true;

            case R.id.action_menu9:
                startActivity(new Intent(MenuActivity1.this, MenuActivity9.class));
                return true;

            case R.id.action_menu10:
                startActivity(new Intent(MenuActivity1.this, MenuActivity10.class));
                return true;

            case R.id.action_menu11:
                startActivity(new Intent(MenuActivity1.this, MenuActivity11.class));
                return true;

            case R.id.action_menu12:
                startActivity(new Intent(MenuActivity1.this, MenuActivity12.class));
                return true;

            case R.id.action_menu13:
                startActivity(new Intent(MenuActivity1.this, MenuActivity13.class));
                return true;

            case R.id.action_menu14:
                startActivity(new Intent(MenuActivity1.this, MenuActivity14.class));
                return true;

            case R.id.action_menu15:
                startActivity(new Intent(MenuActivity1.this, MenuActivity15.class));
                return true;

            case R.id.action_menu16:
                startActivity(new Intent(MenuActivity1.this, MenuActivity16.class));
                return true;

            case R.id.action_menu17:
                startActivity(new Intent(MenuActivity1.this, MenuActivity17.class));
                return true;

            case R.id.action_menu18:
                startActivity(new Intent(MenuActivity1.this, MenuActivity18.class));
                return true;

            case R.id.action_menu19:
                startActivity(new Intent(MenuActivity1.this, MenuActivity19.class));
                return true;

            case R.id.action_menu20:
                startActivity(new Intent(MenuActivity1.this, MenuActivity20.class));
                return true;
        }

        return true;
    }
}
