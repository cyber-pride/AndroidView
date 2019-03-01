package com.bluapp.androidview.SearchView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;

import com.bluapp.androidview.R;

public class SearchViewActivity15 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view15);
        search = (SearchView) findViewById(R.id.search);
        ImageView searchbtn = (ImageView) search.findViewById(android.support.v7.appcompat.R.id.search_close_btn);
        searchbtn.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
    }
}
