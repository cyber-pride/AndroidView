package com.bluapp.androidview.Retrofit;

import android.app.ProgressDialog;
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
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitActivity12 extends AppCompatActivity {
    private RecyclerView list;
    private ProgressDialog progressDialog;
    private String baseUrl;
    private List<RetrofitGetResponse> responseList;
    private adapter recyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit12);
        list = (RecyclerView)findViewById(R.id.list);
        baseUrl = "http://dummy.restapiexample.com/";
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RetrofitActivity12.this, responseList);
        list.addItemDecoration(new DividerItemDecoration(RetrofitActivity12.this, DividerItemDecoration.VERTICAL));
        list.setAdapter(recyclerAdapter);
        fetchData();
    }

    private void fetchData(){
        progressDialog = new ProgressDialog(RetrofitActivity12.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining retrofit api service
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        ApiService service = retrofit.create(ApiService.class);
        Call<List<RetrofitGetResponse>> call = service.GetEmployeeData();
        //calling the api
        call.enqueue(new Callback<List<RetrofitGetResponse>>() {
            @Override
            public void onResponse(Call<List<RetrofitGetResponse>> call, Response<List<RetrofitGetResponse>> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                //if there is no error
                responseList = response.body();
                recyclerAdapter.setEmployeeList(responseList);
                Toast.makeText(RetrofitActivity12.this, "Status Code: "+String.valueOf(response.code()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<RetrofitGetResponse>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<RetrofitGetResponse> responseList;

        public adapter(Context context, List<RetrofitGetResponse> data) {
            this.context = context;
            this.responseList = data;
        }

        public void setEmployeeList(List<RetrofitGetResponse> resList) {
            this.responseList = resList;
            notifyDataSetChanged();
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.retrofit_adapter1, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
            holder.name.setText(responseList.get(position).getEmployeeName());
            holder.salary.setText(responseList.get(position).getEmployeeSalary());
            holder.age.setText(responseList.get(position).getEmployeeAge());
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
            TextView salary;
            TextView age;

            public myViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.Name);
                salary = (TextView) itemView.findViewById(R.id.Salary);
                age = (TextView) itemView.findViewById(R.id.Age);
            }
        }
    }

    private interface ApiService {
        @GET("api/v1/employees")
        Call<List<RetrofitGetResponse>> GetEmployeeData();
    }

    private class RetrofitGetResponse{
        @SerializedName("profile_image")
        private String profileImage;
        @SerializedName("employee_name")
        private String employeeName;
        @SerializedName("employee_salary")
        private String employeeSalary;
        @SerializedName("id")
        private String id;
        @SerializedName("employee_age")
        private String employeeAge;

        public void setProfileImage(String profileImage){
            this.profileImage = profileImage;
        }
        public String getProfileImage(){
            return profileImage;
        }
        public void setEmployeeName(String employeeName){
            this.employeeName = employeeName;
        }
        public String getEmployeeName(){
            return employeeName;
        }
        public void setEmployeeSalary(String employeeSalary){
            this.employeeSalary = employeeSalary;
        }
        public String getEmployeeSalary(){
            return employeeSalary;
        }
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return id;
        }
        public void setEmployeeAge(String employeeAge){
            this.employeeAge = employeeAge;
        }
        public String getEmployeeAge(){
            return employeeAge;
        }
    }
}
