package com.bluapp.androidview.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class Fragment4 extends Fragment implements FragmentActivity4.OnBackPressedListner{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);

        return view;
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getActivity(),"OnBackpress Click",Toast.LENGTH_LONG).show();
        return false;
    }
}