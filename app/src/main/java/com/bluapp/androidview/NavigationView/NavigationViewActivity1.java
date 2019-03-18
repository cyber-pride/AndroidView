package com.bluapp.androidview.NavigationView;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.Menu;
import android.content.Intent;

import com.bluapp.androidview.R;


public class NavigationViewActivity1 extends AppCompatActivity{
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name, R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.navigationview_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_navigationviewactivity2:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity2.class));
                return true;
            case R.id.action_navigationviewactivity3:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity3.class));
                return true;
            case R.id.action_navigationviewactivity4:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity4.class));
                return true;
            case R.id.action_navigationviewactivity5:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity5.class));
                return true;
            case R.id.action_navigationviewactivity6:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity6.class));
                return true;
            case R.id.action_navigationviewactivity7:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity7.class));
                return true;
            case R.id.action_navigationviewactivity8:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity8.class));
                return true;
            case R.id.action_navigationviewactivity9:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity9.class));
                return true;
            case R.id.action_navigationviewactivity10:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity10.class));
                return true;
            case R.id.action_navigationviewactivity11:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity11.class));
                return true;
            case R.id.action_navigationviewactivity12:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity12.class));
                return true;
            case R.id.action_navigationviewactivity13:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity13.class));
                return true;
            case R.id.action_navigationviewactivity14:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity14.class));
                return true;
            case R.id.action_navigationviewactivity15:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity15.class));
                return true;
            case R.id.action_navigationviewactivity16:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity16.class));
                return true;
            case R.id.action_navigationviewactivity17:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity17.class));
                return true;
            case R.id.action_navigationviewactivity18:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity18.class));
                return true;
            case R.id.action_navigationviewactivity19:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity19.class));
                return true;
            case R.id.action_navigationviewactivity20:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity20.class));
                return true;
            case R.id.action_navigationviewactivity21:
                startActivity(new Intent(NavigationViewActivity1.this, NavigationViewActivity21.class));
                return true;

        }
        return true;
    }

}

