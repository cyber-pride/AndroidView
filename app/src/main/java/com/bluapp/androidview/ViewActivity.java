package com.bluapp.androidview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.Button.ButtonActivity;
import com.bluapp.androidview.EditText.EditTextActivity;
import com.bluapp.androidview.Fragment.FragmentActivity1;
import com.bluapp.androidview.RecyclerView.RecyclerViewActivity1;
import com.bluapp.androidview.SearchView.SearchViewActivity1;
import com.bluapp.androidview.WebView.WebViewActivity1;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void Button(View view){
        startActivity(new Intent(ViewActivity.this, ButtonActivity.class));
    }

    public void EditText(View view){
        startActivity(new Intent(ViewActivity.this, EditTextActivity.class));
    }

    public void RecyclerView(View view){
        startActivity(new Intent(ViewActivity.this, RecyclerViewActivity1.class));
    }

    public void WebView(View view){
        startActivity(new Intent(ViewActivity.this, WebViewActivity1.class));
    }

    public void SearchView(View view){
        startActivity(new Intent(ViewActivity.this, SearchViewActivity1.class));
    }

    public void Fragment(View view){
        startActivity(new Intent(ViewActivity.this, FragmentActivity1.class));
    }
}
