package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class DatePickerAndTimePickerActivity8 extends AppCompatActivity {
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker8);
        //setting default date
        year = 2019;
        month = 2;
        day = 6;

    }

    public void ShowDatePicker(View view){
        DatePickerDialog dpd = new DatePickerDialog(DatePickerAndTimePickerActivity8.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int mYear, int monthOfYear, int dayOfMonth) {
                year = mYear;
                month = monthOfYear;
                day = dayOfMonth;
                int mMonth1 = month + 1;
                Toast.makeText(DatePickerAndTimePickerActivity8.this,"Year "+year+"/Month "+mMonth1+"/Day "+day,Toast.LENGTH_LONG).show();
            }
        }, year, month, day);
        dpd.show();
    }
}
