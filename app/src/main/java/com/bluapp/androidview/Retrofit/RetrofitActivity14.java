package com.bluapp.androidview.Retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.bluapp.androidview.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class RetrofitActivity14 extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private ProgressDialog progressDialog;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit14);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
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
        String enteredusername = username.getText().toString();
        String enteredpassword = password.getText().toString();

        progressDialog = new ProgressDialog(RetrofitActivity14.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining retrofit api service
        ApiService loginService = ServiceGenerator.createService(ApiService.class, enteredusername, enteredpassword);
        Call<PostResponse> call = loginService.loginData();
        //calling the api
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
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
        @GET("basic-auth")
        Call<PostResponse> loginData();
    }

    private class PostResponse{
        @SerializedName("id")
        @Expose
        private String auth;
        public String getAuth() {
            return auth;
        }
        public void setId(String auth) {
            this.auth = auth;
        }
    }

    private static class ServiceGenerator {
        public static final String API_BASE_URL = "https://postman-echo.com/";
        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());
        private static Retrofit retrofit = builder.build();
        public <S> S createService(Class<S> serviceClass) {
            return createService(serviceClass, null, null);
        }
        public static <S> S createService(Class<S> serviceClass, String username, String password) {
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                String authToken = Credentials.basic(username, password);
                return createService(serviceClass, authToken);
            }
            return createService(serviceClass, null);
        }

        public static <S> S createService(Class<S> serviceClass, final String authToken) {
            if (!TextUtils.isEmpty(authToken)) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);
                if (!httpClient.interceptors().contains(interceptor)) {
                    httpClient.addInterceptor(interceptor);
                    httpClient.addInterceptor(loggingInterceptor);
                    builder.client(httpClient.build());
                    retrofit = builder.build();
                }
            }
            return retrofit.create(serviceClass);
        }
    }

    private static class AuthenticationInterceptor implements Interceptor {
        private String authToken;
        public AuthenticationInterceptor(String token) {
            this.authToken = token;
        }
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Request original = chain.request();
            okhttp3.Request.Builder builder = original.newBuilder()
                    .header("Authorization", authToken);
            okhttp3.Request request = builder.build();
            return chain.proceed(request);
        }
    }
}
