package com.bluapp.androidview.SearchView;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.bluapp.androidview.R;

public class SearchViewActivity14 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view14);
        search = (SearchView) findViewById(R.id.search);
        TextView searchText = (TextView) search.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Font.otf");
        searchText.setTypeface(typeface);
    }
}
