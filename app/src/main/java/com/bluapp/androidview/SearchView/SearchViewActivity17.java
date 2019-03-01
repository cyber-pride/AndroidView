package com.bluapp.androidview.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ArrayAdapter;

import com.bluapp.androidview.R;

public class SearchViewActivity17 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view17);
        search = (SearchView) findViewById(R.id.search);
        String data[]={"Emmanuel", "Olayemi", "Henrry", "Mark", "Steve", "Ayomide", "David", "Anthony", "Adekola", "Adenuga"};
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) search.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);
        searchAutoComplete.setAdapter(dataAdapter);
    }
}
