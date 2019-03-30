package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity6 extends AppCompatActivity implements ChooseDateFragment.DateListner{
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker6);

    }

    public void ShowDatePicker(View view){
       ChooseDateFragment chooseDateFragment = new ChooseDateFragment();
       chooseDateFragment.show(getSupportFragmentManager(), "");
    }

    @Override
    public void onDateSelected(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
