package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity15 extends AppCompatActivity implements ChooseTimeFragment.TimeListner{
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker15);
    }

    public void ShowTimePicker(View view){
        ChooseTimeFragment chooseTimeFragment = new ChooseTimeFragment();
        chooseTimeFragment.show(getSupportFragmentManager(), "");
    }


    @Override
    public void onTimeSelected(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}
