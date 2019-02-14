package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity4 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view4);
        list = (RecyclerView) findViewById(R.id.list);
        //Data
        ArrayList<String> category = new ArrayList<>();
        category.add("Top");
        category.add("Best");
        category.add("Category");
        category.add("Try now");
        category.add("Country");
        category.add("Tools");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity4.this, category);
        list.setAdapter(recyclerAdapter);
    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<String> mData;
        public adapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
        }
        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter4, parent, false);
            return new myViewHolder(view);
        }
        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            holder.categorysub.setText(mData.get(position));
            //Data
            ArrayList<String> country = new ArrayList<>();
            country.add("Nigeria");
            country.add("China");
            country.add("USA");
            country.add("Ghana");
            country.add("Canada");
            country.add("Finland");
            country.add("Denmark");
            country.add("Argentina");
            country.add("Andorra");
            country.add("Togo");

            LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity4.this, LinearLayoutManager.HORIZONTAL, false);
            holder.recyclerViewsub.setLayoutManager(layoutManager);
            childadapter recyclerAdapter = new childadapter(RecyclerViewActivity4.this, country);
            holder.recyclerViewsub.setAdapter(recyclerAdapter);
        }
        @Override
        public int getItemCount() {
            return mData.size();
        }
        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView categorysub;
            RecyclerView recyclerViewsub;
            public myViewHolder(View itemView) {
                super(itemView);
                categorysub = (TextView) itemView.findViewById(R.id.category);
                recyclerViewsub = (RecyclerView) itemView.findViewById(R.id.list);
            }
        }
    }

    private class childadapter extends RecyclerView.Adapter<childadapter.myViewHolder> {
        Context context;
        List<String> mData;
        public childadapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
        }
        @Override
        public childadapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter3, parent, false);
            return new myViewHolder(view);
        }
        @Override
        public void onBindViewHolder(childadapter.myViewHolder holder, int position) {
            holder.country.setText(mData.get(position));
        }
        @Override
        public int getItemCount() {
            return mData.size();
        }
        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView country;
            public myViewHolder(View itemView) {
                super(itemView);
                country = (TextView) itemView.findViewById(R.id.country);
            }
        }
    }

}
