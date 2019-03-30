package com.bluapp.androidview.DatePickerAndTimePickerActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.bluapp.androidview.R;


public class ChooseTimeFragment extends DialogFragment implements View.OnClickListener {

    private TimePicker timePicker;
    private Button button;
    private boolean isTimesetted = false;
    private int hour;
    private int minute;
    private TimeListner listner;
    private TimePicker timepicker;

    public interface TimeListner{
        public void onTimeSelected(int hour, int minute);
    }

    public ChooseTimeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_choose_time, container, false);
        getDialog().setTitle("TimePicker");
        timepicker = (TimePicker) rootview.findViewById(R.id.timepicker);
        button = (Button) rootview.findViewById(R.id.button);
        button.setOnClickListener(this);
        if(isTimesetted){
            timepicker.setHour(hour);
            timePicker.setMinute(minute);
        }
        return rootview;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                int hour = timepicker.getHour();
                int minute = timepicker.getMinute();
                listner.onTimeSelected(hour, minute);
                break;
        }
        this.dismiss();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (TimeListner) context;
    }

    public void setTime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
        this.isTimesetted = true;
    }


}
