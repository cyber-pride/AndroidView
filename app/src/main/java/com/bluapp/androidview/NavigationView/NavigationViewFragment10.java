package com.bluapp.androidview.NavigationView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluapp.androidview.R;

public class NavigationViewFragment10 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_view_fragment10, container, false);
        ((DrawerLocker) getActivity()).setDrawerEnabled(false);
        return view;
    }

}

