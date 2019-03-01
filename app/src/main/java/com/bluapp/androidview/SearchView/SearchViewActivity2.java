package com.bluapp.androidview.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.bluapp.androidview.R;

public class SearchViewActivity2 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view2);
        search = (SearchView) findViewById(R.id.search);
        search.setQuery("TextToChange", false);
        search.clearFocus();
    }
}
