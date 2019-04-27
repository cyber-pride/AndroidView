package com.bluapp.androidview.Volley;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bluapp.androidview.R;

import java.util.HashMap;
import java.util.Map;


public class VolleyActivity6 extends AppCompatActivity {
    private EditText title;
    private EditText body;
    private EditText userid;
    private Button submit;
    private ProgressDialog progressDialog;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley6);
        title = (EditText) findViewById(R.id.title);
        body = (EditText) findViewById(R.id.body);
        userid = (EditText) findViewById(R.id.userid);
        submit = (Button) findViewById(R.id.submit);
        baseUrl = "http://jsonplaceholder.typicode.com/posts";

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                submitData();
            }
        });
    }

    private void submitData(){
        final String enteredtitle = title.getText().toString();
        final String enteredbody = body.getText().toString();
        final String entereduserid = userid.getText().toString();

        progressDialog = new ProgressDialog(VolleyActivity6.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining api service
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity6.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, baseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyerror){
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), volleyerror.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", enteredtitle);
                params.put("body", enteredbody);
                params.put("userId", entereduserid);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
