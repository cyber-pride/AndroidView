package com.bluapp.androidview.SearchView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class SearchViewActivity16 extends AppCompatActivity {
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view16);
        search = (SearchView) findViewById(R.id.search);

        search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchViewActivity16.this,"SearchView is expanded open", Toast.LENGTH_LONG).show();
            }
        });

        search.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(SearchViewActivity16.this,"SearchView expanded close", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
