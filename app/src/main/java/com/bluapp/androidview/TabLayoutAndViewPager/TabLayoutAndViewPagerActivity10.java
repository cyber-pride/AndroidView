package com.bluapp.androidview.TabLayoutAndViewPager;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.R;

public class TabLayoutAndViewPagerActivity10 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int int_items = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager10);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        dynamicindicator();
    }

    private void dynamicindicator(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    tabLayout.setSelectedTabIndicatorColor(Color.RED);
                }else if(tab.getPosition()==1){
                    tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
                }else if(tab.getPosition()==2){
                    tabLayout.setSelectedTabIndicatorColor(Color.GREEN);
                }else if(tab.getPosition()==3){
                    tabLayout.setSelectedTabIndicatorColor(Color.YELLOW);
                }else{
                    tabLayout.setSelectedTabIndicatorColor(Color.GRAY);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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

}

