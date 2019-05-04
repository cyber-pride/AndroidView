package com.bluapp.androidview.RoomDatabase;

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
import android.widget.Toast;

import com.bluapp.androidview.R;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class RoomDatabaseActivity4 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;
    private UserDatabase userDatabase;
    private List<User> responseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database4);
        list = (RecyclerView)findViewById(R.id.list);
        userDatabase = UserDatabase.getInstance(this);
        readData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RoomDatabaseActivity4.this, responseList);
        list.addItemDecoration(new DividerItemDecoration(RoomDatabaseActivity4.this, DividerItemDecoration.VERTICAL));
        list.setAdapter(recyclerAdapter);
    }

    private void readData(){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDatabase.userDAO().getuserList();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    responseList = userDatabase.userDAO().getuserList();
                        recyclerAdapter.setList(responseList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity4.this, "Empty data",Toast.LENGTH_LONG).show();
                    }
                });
    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<User> responseList;

        public adapter(Context context, List<User> data) {
            this.context = context;
            this.responseList = data;
        }

        public void setList(List<User> resList) {
            this.responseList = resList;
            notifyDataSetChanged();
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.room_adapter1, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            holder.name.setText(responseList.get(position).getName());
        }

        @Override
        public int getItemCount() {
            if(responseList != null){
                return responseList.size();
            }
            return 0;

        }

        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView name;

            public myViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.Name);
            }
        }
    }
}
