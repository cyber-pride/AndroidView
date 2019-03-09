package com.bluapp.androidview.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class Fragment1 extends Fragment {
    private String Tag = "Home";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        Fragment visibleFragment = getActivity().getSupportFragmentManager().findFragmentByTag(Tag);
        if(visibleFragment != null && visibleFragment.getUserVisibleHint()){
            Toast.makeText(getActivity(), "Fragment Visible", Toast.LENGTH_LONG).show();
        }
        return view;
    }



}

