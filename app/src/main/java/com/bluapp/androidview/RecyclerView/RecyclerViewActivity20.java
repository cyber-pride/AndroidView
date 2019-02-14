package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity20 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view20);
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity20.this, country);
        list.addItemDecoration(new DividerItemDecoration(list.getContext(), layoutManager.getOrientation()));
        list.setAdapter(recyclerAdapter);
    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<String> mData;
        int index = -1;

        public adapter(Context context, List<String> data) {
            this.context = context;
            this.mData = data;
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter20, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, final int position) {
            holder.country.setText(mData.get(position));
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = position;
                    notifyDataSetChanged();
                }
            });

            if(index==position){
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FF4081"));
                holder.country.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                holder.relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.country.setTextColor(Color.parseColor("#000000"));
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder {
            RelativeLayout relativeLayout;
            TextView country;

            public myViewHolder(View itemView) {
                super(itemView);
                relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
                country = (TextView) itemView.findViewById(R.id.country);
            }
        }
    }
}
