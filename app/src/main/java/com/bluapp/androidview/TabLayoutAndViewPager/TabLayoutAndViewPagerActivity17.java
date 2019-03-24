package com.bluapp.androidview.TabLayoutAndViewPager;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAndViewPagerActivity17 extends AppCompatActivity {
    private ViewPager parentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager17);
        parentPager = (ViewPager)findViewById(R.id.viewpager);

        List<ViewPager> pagers = new ArrayList<ViewPager>();
        for(int j = 0; j<3; j++){
            List<LinearLayout> list = new ArrayList<LinearLayout>();
            for(int i = 0; i<5; i++){
                LinearLayout linearLayout = new LinearLayout(this);
                TextView textView = new TextView(this);
                textView.setText("This is the"+i+"th page in PagerItem"+j);
                linearLayout.addView(textView);
                textView.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) textView.getLayoutParams();
                params.gravity = Gravity.CENTER;
                list.add(linearLayout);
            }
            ChildAdapter childAdapter = new ChildAdapter(list);
            final ViewPager childPager = (ViewPager) LayoutInflater.from(this).inflate(R.layout.child_view_pager_17, null).findViewById(R.id.viewpager);
            childPager.setAdapter(childAdapter);
            childPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
            pagers.add(childPager);
        }
        ParentAdapter parentAdapter = new ParentAdapter(pagers);
        parentPager.setAdapter(parentAdapter);


    }

    private class ParentAdapter extends PagerAdapter {

        private List<ViewPager> data;

        public ParentAdapter(List<ViewPager> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }


        @Override
        public int getItemPosition(Object object) {
            return data.indexOf(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ViewPager viewPager = data.get(position);
           if(viewPager.getParent() != null){
               ((ViewGroup) viewPager.getParent()).removeView(viewPager);
           }
           container.addView(viewPager);
           return data.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager viewPager = data.get(position);
            container.removeView(viewPager);
           viewPager = null;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }

    private class ChildAdapter extends PagerAdapter {

        private List<LinearLayout> data;

        public ChildAdapter(List<LinearLayout> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }


        @Override
        public int getItemPosition(Object object) {
            return data.indexOf(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout linearLayout = data.get(position);
            container.addView(linearLayout);
            return data.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            LinearLayout linearLayout = data.get(position);
            container.removeView(linearLayout);
            linearLayout = null;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }



}
