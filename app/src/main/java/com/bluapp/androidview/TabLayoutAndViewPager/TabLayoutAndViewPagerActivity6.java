package com.bluapp.androidview.TabLayoutAndViewPager;


import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAndViewPagerActivity6 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter myAdapter;
    private int[] tabIcons = {
         R.drawable.ic_user, R.drawable.ic_user, R.drawable.ic_user, R.drawable.ic_user, R.drawable.ic_user
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager6);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        itemiconcolor();
    }
    private void setupViewPager(ViewPager viewPager){
        myAdapter = new MyAdapter(getSupportFragmentManager());
        myAdapter.addFragment(new TabFragment(), "TabLayout1");
        myAdapter.addFragment(new TabFragment(), "TabLayout2");
        myAdapter.addFragment(new TabFragment(), "TabLayout3");
        myAdapter.addFragment(new TabFragment(), "TabLayout4");
        myAdapter.addFragment(new TabFragment(), "TabLayout5");
        viewPager.setAdapter(myAdapter);
    }

    private void itemiconcolor(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.setTabIconTint(ContextCompat.getColorStateList(TabLayoutAndViewPagerActivity6.this, R.color.colorPrimary));
    }

    private class MyAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mfragmentlist = new ArrayList<>();
        private final List<String> mfragmentTitlelist = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           return mfragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentlist.size();
        }

        public void addFragment(Fragment fragment, String title){
            mfragmentlist.add(fragment);
            mfragmentTitlelist.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mfragmentTitlelist.get(position);
        }
    }

}

