package com.bluapp.androidview.Retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bluapp.androidview.R;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class RetrofitActivity4 extends AppCompatActivity {
    private EditText postid;
    private Button delete;
    private ProgressDialog progressDialog;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit4);
        postid = (EditText) findViewById(R.id.postid);
        delete = (Button) findViewById(R.id.delete);
        baseUrl = "http://jsonplaceholder.typicode.com/";

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                delData();
            }
        });
    }

    private void delData(){
        String enteredpostid = postid.getText().toString();

        progressDialog = new ProgressDialog(RetrofitActivity4.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining retrofit api service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<PostResponse> call = service.delData(enteredpostid);
        //calling the api
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Post Deleted", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private interface ApiService {
        @DELETE("posts/{id}")
        Call<PostResponse> delData(
                @Path("id") String id);
    }

    private class PostResponse{
        @SerializedName("title")
        private String title;
        @SerializedName("body")
        private String body;
        @SerializedName("userId")
        private String userId;
        @SerializedName("id")
        private Integer id;

        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return title;
        }
        public void setBody(String body){
            this.body = body;
        }
        public String getBody(){
            return body;
        }
        public void setUserId(String userId){
            this.userId = userId;
        }
        public String getUserId(){
            return userId;
        }
        public void setId(Integer id){
            this.id = id;
        }
        public Integer getId(){
            return id;
        }
    }
}
