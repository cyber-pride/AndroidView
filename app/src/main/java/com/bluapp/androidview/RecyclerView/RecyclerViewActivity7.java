package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity7 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view7);
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

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        list.setLayoutManager(layoutManager);
        list.addItemDecoration(new SpaceGrid(3, 10, true));
        recyclerAdapter = new adapter(RecyclerViewActivity7.this, country);
        list.setAdapter(recyclerAdapter);
    }


    private class SpaceGrid extends RecyclerView.ItemDecoration{
        private int mSpanCount;
        private int mSpacing;
        private boolean mIncludeEdge;
        private SpaceGrid(int spanCount, int spacing, boolean includeEdge){
            mSpanCount = spanCount;
            mSpacing = spacing;
            mIncludeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % mSpanCount;
            if(mIncludeEdge){
                outRect.left = mSpacing - column * mSpacing / mSpanCount;
                outRect.right =(column + 1) * mSpacing / mSpanCount;
                if(position < mSpanCount){
                    outRect.top = mSpacing;
                }
                outRect.bottom = mSpacing;
            }else{
                outRect.left = column * mSpacing / mSpanCount;
                outRect.right = mSpacing - (column + 1) * mSpacing / mSpanCount;
                if(position < mSpanCount){
                    outRect.top = mSpacing;
                }
            }
        }
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
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter3, parent, false);
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
