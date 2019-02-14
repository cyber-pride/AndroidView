package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity19 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view19);
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
        country.add("Togo");
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity19.this, country);
        list.addItemDecoration(new DividerItemDecoration(list.getContext(), layoutManager.getOrientation()));
        list.setAdapter(recyclerAdapter);

        list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
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
