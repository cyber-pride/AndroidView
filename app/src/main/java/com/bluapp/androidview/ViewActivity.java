package com.bluapp.androidview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.Button.ButtonActivity;
import com.bluapp.androidview.DatePickerAndTimePickerActivity.DatePickerAndTimePickerActivity1;
import com.bluapp.androidview.EditText.EditTextActivity;
import com.bluapp.androidview.Fragment.FragmentActivity1;
import com.bluapp.androidview.Menu.MenuActivity1;
import com.bluapp.androidview.NavigationView.NavigationViewActivity1;
import com.bluapp.androidview.RecyclerView.RecyclerViewActivity1;
import com.bluapp.androidview.Retrofit.RetrofitActivity1;
import com.bluapp.androidview.SearchView.SearchViewActivity1;
import com.bluapp.androidview.TabLayoutAndViewPager.TabLayoutAndViewPagerActivity1;
import com.bluapp.androidview.VideoView.VideoViewActivity1;
import com.bluapp.androidview.Volley.VolleyActivity1;
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

    public void NavigationView(View view){
        startActivity(new Intent(ViewActivity.this, NavigationViewActivity1.class));
    }

    public void TabLayoutAndViewPager(View view){
        startActivity(new Intent(ViewActivity.this, TabLayoutAndViewPagerActivity1.class));
    }

    public void DatePickerAndTimePicker(View view){
        startActivity(new Intent(ViewActivity.this, DatePickerAndTimePickerActivity1.class));
    }

    public void VideoView(View view){
        startActivity(new Intent(ViewActivity.this, VideoViewActivity1.class));
    }

    public void Menu(View view){
        startActivity(new Intent(ViewActivity.this, MenuActivity1.class));
    }

    public void Retrofit(View view){
        startActivity(new Intent(ViewActivity.this, RetrofitActivity1.class));
    }

    public void Volley(View view){
        startActivity(new Intent(ViewActivity.this, VolleyActivity1.class));
    }
}
