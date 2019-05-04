package com.bluapp.androidview.RoomDatabase;

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

public class RoomDatabaseActivity2 extends AppCompatActivity {
    private EditText name;
    private Button update;
    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database2);
        name = (EditText) findViewById(R.id.name);
        update = (Button) findViewById(R.id.updateBtn);
        userDatabase = UserDatabase.getInstance(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredname = name.getText().toString();
                updateUser(enteredname);
            }
        });
    }

    private void updateUser(final String ename){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                User user = new User(1,ename);
                userDatabase.userDAO().update(user);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(RoomDatabaseActivity2.this, "Data update successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity2.this, "Data not updated",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
