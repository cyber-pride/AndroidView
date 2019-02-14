package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity15 extends AppCompatActivity {
    private RecyclerView list;
    private EditText search;
    private adapter recyclerAdapter;
    ArrayList<String> country;
    ArrayList<String> listcountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view15);
        list = (RecyclerView) findViewById(R.id.list);
        search = (EditText) findViewById(R.id.search);
        //Data
        listcountry = getListCountry();
        country = new ArrayList<>();
        country.addAll(listcountry);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity15.this, country);
        list.addItemDecoration(new DividerItemDecoration(list.getContext(), layoutManager.getOrientation()));
        list.setAdapter(recyclerAdapter);


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recyclerAdapter.getFilter().filter(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> implements Filterable {
        Context context;
        List<String> mData;
        NewFilter mfilter;

        public adapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
            mfilter = new NewFilter(adapter.this);
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter1, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            holder.country.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public Filter getFilter(){
            return mfilter;
        }

        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView country;
            public myViewHolder(View itemView) {
                super(itemView);
                country = (TextView) itemView.findViewById(R.id.country);
            }
        }
        public class NewFilter extends Filter {
            public adapter mAdapter;
            public NewFilter(adapter mAdapter){
                super();
                this.mAdapter = mAdapter;
            }

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                country.clear();
                final FilterResults results = new FilterResults();
                if(charSequence.length() == 0){
                    country.addAll(listcountry);
                }else{
                    final String filterPattern =charSequence.toString().toLowerCase().trim();
                    for(String listcountry : listcountry){
                        if(listcountry.toLowerCase().startsWith(filterPattern)){
                            country.add(listcountry);
                        }
                    }
                }
                results.values = country;
                results.count = country.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.mAdapter.notifyDataSetChanged();
            }

        }
    }

    public ArrayList<String> getListCountry(){
        ArrayList<String> listcountry = new ArrayList<>();
        listcountry.add("Nigeria");
        listcountry.add("China");
        listcountry.add("USA");
        listcountry.add("Ghana");
        listcountry.add("Canada");
        listcountry.add("Finland");
        listcountry.add("Denmark");
        listcountry.add("Argentina");
        listcountry.add("Andorra");
        listcountry.add("Togo");
        return listcountry;
    }



}
