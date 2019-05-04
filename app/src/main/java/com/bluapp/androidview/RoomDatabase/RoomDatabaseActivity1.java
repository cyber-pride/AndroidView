package com.bluapp.androidview.RoomDatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class RoomDatabaseActivity1 extends AppCompatActivity {
    private EditText name;
    private Button save;
    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database1);
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
                        Toast.makeText(RoomDatabaseActivity1.this, "Data store successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RoomDatabaseActivity1.this, "Data not store",Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.roomdatabase_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_roomdatabaseactivity2:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity2.class));
                return true;

            case R.id.action_roomdatabaseactivity3:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity3.class));
                return true;

            case R.id.action_roomdatabaseactivity4:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity4.class));
                return true;

            case R.id.action_roomdatabaseactivity5:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity5.class));
                return true;

            case R.id.action_roomdatabaseactivity6:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity6.class));
                return true;

            case R.id.action_roomdatabaseactivity7:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity7.class));
                return true;

            case R.id.action_roomdatabaseactivity8:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity8.class));
                return true;

            case R.id.action_roomdatabaseactivity9:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity9.class));
                return true;

            case R.id.action_roomdatabaseactivity10:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity10.class));
                return true;

            case R.id.action_roomdatabaseactivity11:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity11.class));
                return true;

            case R.id.action_roomdatabaseactivity12:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity12.class));
                return true;

            case R.id.action_roomdatabaseactivity13:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity13.class));
                return true;

            case R.id.action_roomdatabaseactivity14:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity14.class));
                return true;

            case R.id.action_roomdatabaseactivity15:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity15.class));
                return true;

            case R.id.action_roomdatabaseactivity16:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity16.class));
                return true;

            case R.id.action_roomdatabaseactivity17:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity17.class));
                return true;

            case R.id.action_roomdatabaseactivity18:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity18.class));
                return true;

            case R.id.action_roomdatabaseactivity19:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity19.class));
                return true;

            case R.id.action_roomdatabaseactivity20:
                startActivity(new Intent(RoomDatabaseActivity1.this, RoomDatabaseActivity20.class));
                return true;
        }

        return true;
    }
}
