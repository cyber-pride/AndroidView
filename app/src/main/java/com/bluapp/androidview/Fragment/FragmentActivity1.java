package com.bluapp.androidview.Fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bluapp.androidview.R;

public class FragmentActivity1 extends AppCompatActivity {
    private String Tag = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new Fragment1(), Tag).commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.fragment_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_fragmentactivity2:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity2.class));
                return true;
            case R.id.action_fragmentactivity3:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity3.class));
                return true;
            case R.id.action_fragmentactivity4:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity4.class));
                return true;
            case R.id.action_fragmentactivity5:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity5.class));
                return true;
            case R.id.action_fragmentactivity6:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity6.class));
                return true;
            case R.id.action_fragmentactivity7:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity7.class));
                return true;
            case R.id.action_fragmentactivity8:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity8.class));
                return true;
            case R.id.action_fragmentactivity9:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity9.class));
                return true;
            case R.id.action_fragmentactivity10:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity10.class));
                return true;
            case R.id.action_fragmentactivity11:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity11.class));
                return true;
            case R.id.action_fragmentactivity12:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity12.class));
                return true;
            case R.id.action_fragmentactivity13:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity13.class));
                return true;
            case R.id.action_fragmentactivity14:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity14.class));
                return true;
            case R.id.action_fragmentactivity15:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity15.class));
                return true;
            case R.id.action_fragmentactivity16:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity16.class));
                return true;
            case R.id.action_fragmentactivity17:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity17.class));
                return true;
            case R.id.action_fragmentactivity18:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity18.class));
                return true;
            case R.id.action_fragmentactivity19:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity19.class));
                return true;
            case R.id.action_fragmentactivity20:
                startActivity(new Intent(FragmentActivity1.this, FragmentActivity20.class));
                return true;
        }

        return true;
    }
}
