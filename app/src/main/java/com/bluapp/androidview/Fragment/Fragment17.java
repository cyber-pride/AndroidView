package com.bluapp.androidview.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bluapp.androidview.R;

public class Fragment17 extends Fragment{
    private Button btn;
    private Activity activity;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment17, container, false);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    ((sendMessage) activity).message("Hello");
                }catch (ClassCastException cce){

                }
            }
        });

        return view;
    }

    public interface sendMessage{
        public void message(String mes);
    }

}

