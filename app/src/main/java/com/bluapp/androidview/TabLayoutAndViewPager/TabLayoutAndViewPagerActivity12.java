package com.bluapp.androidview.TabLayoutAndViewPager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAndViewPagerActivity12 extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout layout_dots;
    private MyAdapter adapter;
    private static String[] array_welcome_title = {"Hello", "Howdy", "Hi", "Morning",};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager12);
        layout_dots = (LinearLayout) findViewById(R.id.layout_dots);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        adapter = new MyAdapter(this, new ArrayList<TextViewPager12>());
        final List<TextViewPager12> items = new ArrayList<>();
        for (int i = 0; i < array_welcome_title.length; i++) {
            TextViewPager12 obj = new TextViewPager12();
            obj.name = array_welcome_title[i];
            items.add(obj);
        }
        adapter.setItems(items);
        viewPager.setAdapter(adapter);
        // displaying selected image first
        viewPager.setCurrentItem(0);
        addBottomDots(layout_dots, adapter.getCount(), 0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int pos) {
                ((TextView) findViewById(R.id.title)).setText(items.get(pos).name);
                addBottomDots(layout_dots, adapter.getCount(), pos);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });



}



    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];
        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            layout_dots.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
        }
    }

    private class MyAdapter extends PagerAdapter {

        private Activity act;
        private List<TextViewPager12> items;

        // constructor
        public MyAdapter(Activity activity, List<TextViewPager12> items) {
            this.act = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public TextViewPager12 getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<TextViewPager12> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final TextViewPager12 o = items.get(position);
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.tablayout_and_viewpager_adapter_12, container, false);

            TextView title = (TextView) v.findViewById(R.id.title);
            title.setText(o.name);

            ((ViewPager) container).addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);
        }

    }

}
