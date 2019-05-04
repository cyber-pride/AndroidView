package com.bluapp.androidview.RoomDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bluapp.androidview.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class RoomDatabaseActivity5 extends AppCompatActivity {
    private TextView jsontxt;
    private Button genjson;
    private UserDatabase userDatabase;
    private List<User> responseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database5);
        jsontxt = (TextView) findViewById(R.id.genjson);
        genjson = (Button) findViewById(R.id.genBtn);
        userDatabase = UserDatabase.getInstance(this);
        genjson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateData();
            }
        });
    }

    private void generateData(){
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
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<User>>(){}.getType();
                        String json = gson.toJson(responseList, type);
                        jsontxt.setText(json);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity5.this, "Empty data",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
