package com.bluapp.androidview.Volley;

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

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bluapp.androidview.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VolleyActivity12 extends AppCompatActivity {
    private RecyclerView list;
    private ProgressDialog progressDialog;
    private String baseUrl;
    private List<VolleyGetResponse> responseList;
    private adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley12);
        list = (RecyclerView)findViewById(R.id.list);
        baseUrl = "http://dummy.restapiexample.com/api/v1/employees";
        responseList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(VolleyActivity12.this, responseList);
        list.addItemDecoration(new DividerItemDecoration(VolleyActivity12.this, DividerItemDecoration.VERTICAL));
        list.setAdapter(recyclerAdapter);
        fetchData();
    }

    private void fetchData(){
        progressDialog = new ProgressDialog(VolleyActivity12.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining api service
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity12.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, baseUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length(); i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);
                        VolleyGetResponse volleyGetResponse = new VolleyGetResponse();
                        volleyGetResponse.setId(jsonObject.getString("id"));
                        volleyGetResponse.setEmployeeName(jsonObject.getString("employee_name"));
                        volleyGetResponse.setEmployeeSalary(jsonObject.getString("employee_salary"));
                        volleyGetResponse.setEmployeeAge(jsonObject.getString("employee_age"));
                        volleyGetResponse.setProfileImage(jsonObject.getString("profile_image"));
                        progressDialog.dismiss();
                        responseList.add(volleyGetResponse);
                        recyclerAdapter.setEmployeeList(responseList);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyerror){
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), volleyerror.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Cookie", "name=value");
            return headers;
        }
        };
         requestQueue.add(jsonArrayRequest);
    }

    private class VolleyGetResponse{
        private String profileImage;
        private String employeeName;
        private String employeeSalary;
        private String id;
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

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<VolleyGetResponse> responseList;

        public adapter(Context context, List<VolleyGetResponse> data) {
            this.context = context;
            this.responseList = data;
        }

        public void setEmployeeList(List<VolleyGetResponse> resList) {
            this.responseList = resList;
            notifyDataSetChanged();
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.volley_adapter1, parent, false);
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
}
