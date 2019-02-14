package com.bluapp.androidview.RecyclerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity12 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view12);
        list = (RecyclerView) findViewById(R.id.list);
        //Data
        ArrayList<CountryDataItem> DataItems = new ArrayList<>();
        ArrayList<ChildDataItem> ChildDataItems = new ArrayList<>();
        CountryDataItem ParentDataItem;
        ChildDataItem ChildDataItem;
        ParentDataItem = new CountryDataItem();
        ParentDataItem.setCountryName("Nigeria");
        //
        ChildDataItem = new ChildDataItem();
        ChildDataItem.setStateName("Lagos");
        ChildDataItems.add(ChildDataItem);
        //
        ChildDataItem = new ChildDataItem();
        ChildDataItem.setStateName("Oyo");
        ChildDataItems.add(ChildDataItem);
        //
        ChildDataItem = new ChildDataItem();
        ChildDataItem.setStateName("Ogun");
        ChildDataItems.add(ChildDataItem);
        //
        ParentDataItem.setChildDataItems(ChildDataItems);
        DataItems.add(ParentDataItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity12.this, DataItems);
        list.addItemDecoration(new DividerItemDecoration(list.getContext(), layoutManager.getOrientation()));
        list.setAdapter(recyclerAdapter);

    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<CountryDataItem> mData;
        public adapter(Context context, List<CountryDataItem> data) {
            this.context = context;
            this.mData = data;
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter12, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            CountryDataItem countryDataItem = mData.get(position);
            holder.country.setText(countryDataItem.countryName);
            int noOfChildTextViews = holder.linearLayout_childItems.getChildCount();
            int noOfChild = countryDataItem.getChildDataItems().size();
            if (noOfChild < noOfChildTextViews) {
                for (int index = noOfChild; index < noOfChildTextViews; index++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                    currentTextView.setVisibility(View.GONE);
                }
            }
            for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
                TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
                currentTextView.setText(countryDataItem.getChildDataItems().get(textViewIndex).getStateName());
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
            TextView country;
            private LinearLayout linearLayout_childItems;

            public myViewHolder(View itemView) {
                super(itemView);
                country = (TextView) itemView.findViewById(R.id.country);
                linearLayout_childItems = itemView.findViewById(R.id.ll_child_items);
                linearLayout_childItems.setVisibility(View.GONE);
                int intMaxNoOfChild = 0;
                for (int index = 0; index < mData.size(); index++) {
                    int intMaxSizeTemp = mData.get(index).getChildDataItems().size();
                    if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
                }
                for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                    TextView textView = new TextView(context);
                    textView.setId(indexView);
                    textView.setPadding(0, 20, 0, 20);
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackground(ContextCompat.getDrawable(context, R.drawable.background_sub_module_text));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    textView.setOnClickListener(this);
                    linearLayout_childItems.addView(textView, layoutParams);
                }
                country.setOnClickListener(this);
            }
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.country) {
                    if (linearLayout_childItems.getVisibility() == View.VISIBLE) {
                        linearLayout_childItems.setVisibility(View.GONE);
                    } else {
                        linearLayout_childItems.setVisibility(View.VISIBLE);
                    }
                } else {
                    TextView textViewClicked = (TextView) view;
                    Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class CountryDataItem implements Serializable {
        private String countryName;
        private ArrayList<ChildDataItem> childDataItems;
        public String getCountryName() {
            return countryName;
        }
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }
        public ArrayList<ChildDataItem> getChildDataItems() {
            return childDataItems;
        }
        public void setChildDataItems(ArrayList<ChildDataItem> childDataItems) {
            this.childDataItems = childDataItems;
        }
    }

    private class ChildDataItem implements Serializable {
        private String stateName;

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }




}
