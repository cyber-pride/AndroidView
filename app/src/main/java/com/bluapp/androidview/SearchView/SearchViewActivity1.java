package com.bluapp.androidview.SearchView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.bluapp.androidview.R;

import java.util.ArrayList;
import java.util.List;

public class SearchViewActivity1 extends AppCompatActivity {
    private RecyclerView recyclerlist;
    private SearchView search;
    private adapter recyclerAdapter;
    ArrayList<String> name;
    ArrayList<String> listname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view1);
        recyclerlist = (RecyclerView) findViewById(R.id.recyclerlist);
        search = (SearchView) findViewById(R.id.search);
        //Data
        listname = getListCountry();
        name = new ArrayList<>();
        name.addAll(listname);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerlist.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(SearchViewActivity1.this, name);
        recyclerlist.addItemDecoration(new DividerItemDecoration(recyclerlist.getContext(), layoutManager.getOrientation()));
        recyclerlist.setAdapter(recyclerAdapter);


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String searchText) {
                recyclerAdapter.getFilter().filter(searchText);
                return false;
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
                name.clear();
                final FilterResults results = new FilterResults();
                if(charSequence.length() == 0){
                    name.addAll(listname);
                }else{
                    final String filterPattern =charSequence.toString().toLowerCase().trim();
                    for(String listname : listname){
                        if(listname.toLowerCase().startsWith(filterPattern)){
                            name.add(listname);
                        }
                    }
                }
                results.values = name;
                results.count = name.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.mAdapter.notifyDataSetChanged();
            }

        }
    }

    public ArrayList<String> getListCountry(){
        ArrayList<String> listname = new ArrayList<>();
        listname.add("Emmanuel");
        listname.add("Olayemi");
        listname.add("Henrry");
        listname.add("Mark");
        listname.add("Steve");
        listname.add("Ayomide");
        listname.add("David");
        listname.add("Anthony");
        listname.add("Adekola");
        listname.add("Adenuga");
        return listname;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.searchview_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_searchviewactivity2:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity2.class));
                return true;
            case R.id.action_searchviewactivity3:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity3.class));
                return true;
            case R.id.action_searchviewactivity4:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity4.class));
                return true;
            case R.id.action_searchviewactivity5:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity5.class));
                return true;
            case R.id.action_searchviewactivity6:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity6.class));
                return true;
            case R.id.action_searchviewactivity7:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity7.class));
                return true;
            case R.id.action_searchviewactivity8:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity8.class));
                return true;
            case R.id.action_searchviewactivity9:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity9.class));
                return true;
            case R.id.action_searchviewactivity10:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity10.class));
                return true;
            case R.id.action_searchviewactivity11:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity11.class));
                return true;
            case R.id.action_searchviewactivity12:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity12.class));
                return true;
            case R.id.action_searchviewactivity13:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity13.class));
                return true;
            case R.id.action_searchviewactivity14:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity14.class));
                return true;
            case R.id.action_searchviewactivity15:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity15.class));
                return true;
            case R.id.action_searchviewactivity16:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity16.class));
                return true;
            case R.id.action_searchviewactivity17:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity17.class));
                return true;
            case R.id.action_searchviewactivity18:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity18.class));
                return true;
            case R.id.action_searchviewactivity19:
                startActivity(new Intent(SearchViewActivity1.this, SearchViewActivity19.class));
                return true;
        }

        return true;
    }
}
