package com.bluapp.androidview.RoomDatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bluapp.androidview.R;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class RoomDatabaseActivity9 extends AppCompatActivity {
    private EditText name;
    private Button save;
    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database9);
        name = (EditText) findViewById(R.id.name);
        save = (Button) findViewById(R.id.saveBtn);
        userDatabase = UserDatabase.getInstance(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredname = name.getText().toString();
                saveUser(enteredname);
            }
        });
    }

    private void saveUser(final String ename){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                User user = new User(ename);
                userDatabase.userDAO().insert(user);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(RoomDatabaseActivity9.this, "Data store successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity9.this, "Data not store",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static void runDb(Context context, UserDatabase userDatabase){
        User user = new User("Inducesmile");
        userDatabase.userDAO().insert(user);
    }
}
