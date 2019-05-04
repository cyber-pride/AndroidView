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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class RoomDatabaseActivity19 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;
    private UserDatabase userDatabase;
    private ArrayList<User> responseList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database19);
        list = (RecyclerView)findViewById(R.id.list);
        userDatabase = UserDatabase.getInstance(this);
        readData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RoomDatabaseActivity19.this, responseList);
        list.addItemDecoration(new DividerItemDecoration(RoomDatabaseActivity19.this, DividerItemDecoration.VERTICAL));
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
                        List<User> users = userDatabase.userDAO().getuserList();
                        for(int i = 0; i < users.size(); i++){
                            responseList.add(new User(users.get(i).getName()));
                        }
                        recyclerAdapter.setList(responseList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity19.this, "Empty data",Toast.LENGTH_LONG).show();
                    }
                });
    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        ArrayList<User> responseList;

        public adapter(Context context, ArrayList<User> data) {
            this.context = context;
            this.responseList = data;
        }

        public void setList(ArrayList<User> resList) {
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
