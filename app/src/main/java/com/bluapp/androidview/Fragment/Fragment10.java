package com.bluapp.androidview.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bluapp.androidview.R;

public class Fragment10 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment10, container, false);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean visible){
        super.setUserVisibleHint(visible);
        if(visible && isResumed()){
            onResume();
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!getUserVisibleHint()){
            return;
        }
        Toast.makeText(getActivity(),"Viewpager fragment is visible",Toast.LENGTH_LONG).show();
    }

}

