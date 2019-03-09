package com.bluapp.androidview.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class Fragment20 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment20, container, false);

        return view;
    }

    public void btnToast(View view){
        Toast.makeText(getActivity(),"Toast Hello",Toast.LENGTH_LONG).show();
    }

}

