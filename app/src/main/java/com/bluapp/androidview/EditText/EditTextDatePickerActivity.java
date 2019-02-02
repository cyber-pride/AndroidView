package com.bluapp.androidview.EditText;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.bluapp.androidview.R;

import java.util.Date;

public class EditTextDatePickerActivity extends AppCompatActivity {
    private EditText date;
    private int  year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_date_picker);
        date = (EditText) findViewById(R.id.datefield);

        //setting default date
        year = 2000;
        month = 5;
        day = 6;

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(EditTextDatePickerActivity.this, mDateSetListener, year, month, day);
                dpd.getDatePicker().setMaxDate(new Date().getTime());
                dpd.show();
            }
        });

    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int mYear, int monthOfYear, int dayOfMonth) {
            year = mYear;
            month = monthOfYear;
            day = dayOfMonth;
            int mMonth1 = month + 1;
            date.setText(new StringBuilder().append(year).append("/").append(mMonth1).append("/").append(day));
        }
    };


}

