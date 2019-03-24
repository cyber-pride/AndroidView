package com.bluapp.androidview.TabLayoutAndViewPager;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.bluapp.androidview.R;

@SuppressWarnings("deprecation")
public class TabLayoutAndViewPagerActivity8 extends TabActivity {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_and_view_pager8);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec TabMenu1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec TabMenu2 = tabHost.newTabSpec("Second Tab");
        TabHost.TabSpec TabMenu3 = tabHost.newTabSpec("Third Tab");

        TabMenu1.setIndicator("Tab1");
        TabMenu1.setContent(new Intent(TabLayoutAndViewPagerActivity8.this, TabHostActivity.class));

        TabMenu2.setIndicator("Tab2");
        TabMenu2.setContent(new Intent(TabLayoutAndViewPagerActivity8.this, TabHostActivity.class));

        TabMenu3.setIndicator("Tab3");
        TabMenu3.setContent(new Intent(TabLayoutAndViewPagerActivity8.this, TabHostActivity.class));

        tabHost.addTab(TabMenu1);
        tabHost.addTab(TabMenu2);
        tabHost.addTab(TabMenu3);
    }
}
