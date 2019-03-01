package com.bluapp.androidview.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.InputType;

import com.bluapp.androidview.R;

public class SearchViewActivity11 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view11);
        search = (SearchView) findViewById(R.id.search);
        search.setInputType(InputType.TYPE_NULL);
    }
}
