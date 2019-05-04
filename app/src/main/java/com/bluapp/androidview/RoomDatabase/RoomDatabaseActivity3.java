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

public class RoomDatabaseActivity3 extends AppCompatActivity {
    private EditText name;
    private Button delete;
    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database3);
        name = (EditText) findViewById(R.id.name);
        delete = (Button) findViewById(R.id.deleteBtn);
        userDatabase = UserDatabase.getInstance(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredname = name.getText().toString();
                deleteUser(enteredname);
            }
        });
    }

    private void deleteUser(final String ename){
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                User user = new User(1, ename);
                userDatabase.userDAO().delete(user);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(RoomDatabaseActivity3.this, "Data deleted successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity3.this, "Data not deleted",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
