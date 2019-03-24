package com.bluapp.androidview.TabLayoutAndViewPager;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bluapp.androidview.R;

public class TabLayoutAndViewPagerActivity1 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int int_items = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager1);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        selectTabIndex(3);
    }

    private void selectTabIndex(final int index){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tabLayout.setScrollPosition(index, 0, true);
                viewPager.setCurrentItem(index);
               // or
                // tabLayout.getTabAt(index).select();
            }
        },100);

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new TabFragment();
                case 1 : return new TabFragment();
                case 2 : return new TabFragment();
                case 3 : return new TabFragment();
                case 4 : return new TabFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "TabLayout1";
                case 1 :
                    return "TabLayout2";
                case 2 :
                    return "TabLayout3";
                case 3 :
                    return "TabLayout4";
                case 4 :
                    return "TabLayout5";
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.tablayoutandviewpager_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_tablayoutandviewpager2:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity2.class));
                return true;

            case R.id.action_tablayoutandviewpager3:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity3.class));
                return true;

            case R.id.action_tablayoutandviewpager4:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity4.class));
                return true;

            case R.id.action_tablayoutandviewpager5:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity5.class));
                return true;

            case R.id.action_tablayoutandviewpager6:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity6.class));
                return true;

            case R.id.action_tablayoutandviewpager7:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity7.class));
                return true;

            case R.id.action_tablayoutandviewpager8:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity8.class));
                return true;

            case R.id.action_tablayoutandviewpager9:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity9.class));
                return true;

            case R.id.action_tablayoutandviewpager10:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity10.class));
                return true;

            case R.id.action_tablayoutandviewpager11:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity11.class));
                return true;

            case R.id.action_tablayoutandviewpager12:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity12.class));
                return true;

            case R.id.action_tablayoutandviewpager13:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity13.class));
                return true;

            case R.id.action_tablayoutandviewpager14:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity14.class));
                return true;

            case R.id.action_tablayoutandviewpager15:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity15.class));
                return true;

            case R.id.action_tablayoutandviewpager16:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity16.class));
                return true;

            case R.id.action_tablayoutandviewpager17:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity17.class));
                return true;

            case R.id.action_tablayoutandviewpager18:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity18.class));
                return true;

            case R.id.action_tablayoutandviewpager19:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity19.class));
                return true;

            case R.id.action_tablayoutandviewpager20:
                startActivity(new Intent(TabLayoutAndViewPagerActivity1.this, TabLayoutAndViewPagerActivity20.class));
                return true;


        }
        return true;
    }

}
