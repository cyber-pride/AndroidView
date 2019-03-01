package com.bluapp.androidview.SearchView;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.bluapp.androidview.R;

public class SearchViewActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view9);
        showSearchDialog();
    }

    public void showSearchDialog(){
        final SearchView taskSearchview = new SearchView(this);
        taskSearchview.setQueryHint("Search Name");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Title");
        alertDialogBuilder.setMessage("What do you want to Search?");
        alertDialogBuilder.setView(taskSearchview);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
