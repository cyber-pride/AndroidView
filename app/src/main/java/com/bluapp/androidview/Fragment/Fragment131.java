package com.bluapp.androidview.Fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluapp.androidview.R;

public class Fragment131 extends Fragment{
    private TextView txt;

    public Fragment131() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment131, container, false);
        txt = (TextView)view.findViewById(R.id.txt);
        final SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        model.getMessage().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                txt.setText(o.toString());
            }
        });
        return view;
    }

}


