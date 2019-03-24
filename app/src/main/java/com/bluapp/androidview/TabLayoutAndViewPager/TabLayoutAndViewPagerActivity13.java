package com.bluapp.androidview.TabLayoutAndViewPager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bluapp.androidview.R;

public class TabLayoutAndViewPagerActivity13 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int int_items = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager13);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
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
     @Override
        public void destroyItem(ViewGroup container, int position, Object object){
         ((ViewPager) container).removeView((View)object);
     }
    }

}
