package com.bluapp.androidview.TabLayoutAndViewPager;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAndViewPagerActivity14 extends AppCompatActivity {
    private ViewPager viewPager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager14);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myAdapter = new MyAdapter();
        viewPager.setAdapter(myAdapter);

        LayoutInflater inflater = getLayoutInflater();
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.tabwithviewpager14,null);
        myAdapter.addView(relativeLayout, 0);
        myAdapter.notifyDataSetChanged();

    }

    public void addView(View newPage){
        int pageindex = myAdapter.addView(newPage);
        viewPager.setCurrentItem(pageindex, true);
    }

    public void removeView(View defunctPage){
        int pageindex = myAdapter.removeView(viewPager, defunctPage);
        if(pageindex == myAdapter.getCount())
            pageindex--;
        viewPager.setCurrentItem(pageindex);
    }

    public View getCurrentPage(){
        return  myAdapter.getView(viewPager.getCurrentItem());
    }

    public void setCurrentPage(View pageToShow){
        viewPager.setCurrentItem(myAdapter.getItemPosition(pageToShow), true);
    }

    private class MyAdapter extends PagerAdapter {
        private final List<View> views = new ArrayList<View>();


        @Override
        public int getItemPosition(Object object) {
            int index = views.indexOf(object);
            if(index == -1)
                return POSITION_NONE;
            else
            return index;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, @NonNull Object object) {
            return view == object;
        }

        public int addView(View view){
            return addView(view, views.size());
        }


        public int addView(View view, int position){
            views.add(position, view);
           return position;
        }

        public int removeView(ViewPager pager, View view){
            return removeView(pager, views.indexOf(view));
        }

        public int removeView(ViewPager pager, int position){
            pager.setAdapter(null);
            views.remove(position);
            pager.setAdapter(this);
            return position;
        }

        public View getView(int position){
            return views.get(position);
        }

    }

}

