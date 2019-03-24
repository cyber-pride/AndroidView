package com.bluapp.androidview.TabLayoutAndViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.R;

public class TabLayoutAndViewPagerActivity15 extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager15);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    public class MyAdapter extends FragmentPagerAdapter {
        private MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0 : return new ViewPagerFragment15();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }

}
