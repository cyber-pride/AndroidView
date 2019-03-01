package com.bluapp.androidview.SearchView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.bluapp.androidview.R;

public class SearchViewActivity13 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view13);
        search = (SearchView) findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startActivity(new Intent(SearchViewActivity13.this, SearchViewActivity1.class));
                return false;
            }
            @Override
            public boolean onQueryTextChange(String text) {
                return false;
            }
        });
    }
}
