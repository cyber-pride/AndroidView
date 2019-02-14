package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity5 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;
    private LinearLayoutManager layoutManager;
    private int visibleItemCount, totalItemCount, firstVisibleItemPosition, lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view5);
        list = (RecyclerView) findViewById(R.id.list);

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
        country.add("Angola");
        country.add("Benin");
        country.add("Brazil");
        country.add("Chile");
        country.add("Denmark");
        country.add("Egypt");
        country.add("Fiji");
        country.add("France");
        country.add("Togo");

        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity5.this, country);
        list.addItemDecoration(new DividerItemDecoration(list.getContext(), layoutManager.getOrientation()));
        list.setAdapter(recyclerAdapter);
        list.addOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            visibleItemCount = layoutManager.getChildCount();
            totalItemCount = layoutManager.getItemCount();
            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            lastVisibleItem = firstVisibleItemPosition +visibleItemCount;
            Toast.makeText(RecyclerViewActivity5.this, "Visible Item Total:"+String.valueOf(visibleItemCount), Toast.LENGTH_SHORT).show();
        }
    };

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<String> mData;

        public adapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
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

        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView country;

            public myViewHolder(View itemView) {
                super(itemView);
                country = (TextView) itemView.findViewById(R.id.country);
            }
        }
    }

}
