package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity1 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);
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
        recyclerAdapter = new adapter(RecyclerViewActivity1.this, country);
        list.addItemDecoration(new CustomDividerItemDecoration(RecyclerViewActivity1.this));
        list.setAdapter(recyclerAdapter);

    }

    private class CustomDividerItemDecoration extends RecyclerView.ItemDecoration{
        private Drawable drawableline;
        private CustomDividerItemDecoration(Context context){
            drawableline = ContextCompat.getDrawable(context, R.drawable.recyclerline);
        }
        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state){
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for(int i = 0; i < childCount; i++){
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + drawableline.getIntrinsicHeight();
                drawableline.setBounds(left, top, right, bottom);
                drawableline.draw(c);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.recyclerview_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_recyclerviewactivity2:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity2.class));
                return true;
            case R.id.action_recyclerviewactivity3:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity3.class));
                return true;
            case R.id.action_recyclerviewactivity4:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity4.class));
                return true;
            case R.id.action_recyclerviewactivity5:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity5.class));
                return true;
            case R.id.action_recyclerviewactivity6:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity6.class));
                return true;
            case R.id.action_recyclerviewactivity7:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity7.class));
                return true;
            case R.id.action_recyclerviewactivity8:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity8.class));
                return true;
            case R.id.action_recyclerviewactivity9:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity9.class));
                return true;
            case R.id.action_recyclerviewactivity10:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity10.class));
                return true;
            case R.id.action_recyclerviewactivity11:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity11.class));
                return true;
            case R.id.action_recyclerviewactivity12:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity12.class));
                return true;
            case R.id.action_recyclerviewactivity13:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity13.class));
                return true;
            case R.id.action_recyclerviewactivity14:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity14.class));
                return true;
            case R.id.action_recyclerviewactivity15:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity15.class));
                return true;
            case R.id.action_recyclerviewactivity16:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity16.class));
                return true;
            case R.id.action_recyclerviewactivity17:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity17.class));
                return true;
            case R.id.action_recyclerviewactivity18:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity18.class));
                return true;
            case R.id.action_recyclerviewactivity19:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity19.class));
                return true;
            case R.id.action_recyclerviewactivity20:
                startActivity(new Intent(RecyclerViewActivity1.this, RecyclerViewActivity20.class));
                return true;
        }

        return true;
    }
}
