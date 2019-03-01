package com.bluapp.androidview.SearchView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bluapp.androidview.R;

public class SearchViewFragment6 extends Fragment {
    private SearchView search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_view_fragment6, container, false);
        search = (SearchView) view.findViewById(R.id.search);
        search.setQueryHint("SearchView Fragment");
        return view;
    }

}
