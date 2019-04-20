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
import com.google.gson.annotations.Expose;
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
import retrofit2.http.Query;

public class RetrofitActivity15 extends AppCompatActivity {
    private RecyclerView list;
    private ProgressDialog progressDialog;
    private String baseUrl;
    private List<Datum> responseList;
    private adapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit15);
        list = (RecyclerView) findViewById(R.id.list);
        baseUrl = "https://api.africoders.com/";
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RetrofitActivity15.this, responseList);
        list.addItemDecoration(new DividerItemDecoration(RetrofitActivity15.this, DividerItemDecoration.VERTICAL));
        list.setAdapter(recyclerAdapter);
        fetchData();
    }

    private void fetchData() {
        progressDialog = new ProgressDialog(RetrofitActivity15.this);
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
        Call<StatusResult> call = service.GetStatuslist("status", "comment:order(id|asc)", "published_at|desc", "10");

        //calling the api
        call.enqueue(new Callback<StatusResult>() {
            @Override
            public void onResponse(Call<StatusResult> call, Response<StatusResult> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                //if there is no error
                if(response.isSuccessful()) {
                    responseList = response.body().getData();
                    recyclerAdapter.setList(responseList);

                }else{
                    Toast.makeText(RetrofitActivity15.this, "Failed", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<StatusResult> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {
        Context context;
        List<Datum> responseList;

        public adapter(Context context, List<Datum> data) {
            this.context = context;
            this.responseList = data;
        }

        public void setList(List<Datum> resList) {
            this.responseList = resList;
            notifyDataSetChanged();
        }

        @Override
        public adapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.retrofit_adapter2, parent, false);
            return new myViewHolder(view);
        }

        @Override
        public void onBindViewHolder(adapter.myViewHolder holder, int position) {
                    holder.comment.setText(responseList.get(position).getBody());
        }

        @Override
        public int getItemCount() {
            if (responseList != null) {
                return responseList.size();
            }
            return 0;
        }

        public class myViewHolder extends RecyclerView.ViewHolder {
            TextView comment;

            public myViewHolder(View itemView) {
                super(itemView);
                comment = (TextView) itemView.findViewById(R.id.Comment);
            }
        }
    }

    private interface ApiService {
        @GET("v1/posts")
        Call<StatusResult> GetStatuslist(
                @Query("category") String category,
                @Query("include") String include,
                @Query("order") String order,
                @Query("limit") String limit);

    }

    private class StatusResult {
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;
        @SerializedName("meta")
        @Expose
        private Meta meta;
        public List<Datum> getData() {
            return data;
        }
        public void setData(List<Datum> data) {
            this.data = data;
        }
        public Meta getMeta() {
            return meta;
        }
        public void setMeta(Meta meta) {
            this.meta = meta;
        }
    }

    private class Comment {
        @SerializedName("data")
        @Expose
        private List<Datum_> data = null;
        public List<Datum_> getData() {
            return data;
        }
        public void setData(List<Datum_> data) {
            this.data = data;
        }
    }

    private class Created {
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private Integer timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public Integer getTimezoneType() {
            return timezoneType;
        }
        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }
        public String getTimezone() {
            return timezone;
        }
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    private class Created_ {
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private Integer timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public Integer getTimezoneType() {
            return timezoneType;
        }
        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }
        public String getTimezone() {
            return timezone;
        }
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    private class Datum {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("url")
        @Expose
        private Object url;
        @SerializedName("likes")
        @Expose
        private Integer likes;
        @SerializedName("dislikes")
        @Expose
        private Integer dislikes;
        @SerializedName("shares")
        @Expose
        private Integer shares;
        @SerializedName("views")
        @Expose
        private String views;
        @SerializedName("replies")
        @Expose
        private String replies;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("created")
        @Expose
        private Created created;
        @SerializedName("updated")
        @Expose
        private Updated updated;
        @SerializedName("published")
        @Expose
        private String published;
        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("comment")
        @Expose
        private Comment comment;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
        public String getSlug() {
            return slug;
        }
        public void setSlug(String slug) {
            this.slug = slug;
        }
        public Object getUrl() {
            return url;
        }
        public void setUrl(Object url) {
            this.url = url;
        }
        public Integer getLikes() {
            return likes;
        }
        public void setLikes(Integer likes) {
            this.likes = likes;
        }
        public Integer getDislikes() {
            return dislikes;
        }
        public void setDislikes(Integer dislikes) {
            this.dislikes = dislikes;
        }
        public Integer getShares() {
            return shares;
        }
        public void setShares(Integer shares) {
            this.shares = shares;
        }
        public String getViews() {
            return views;
        }
        public void setViews(String views) {
            this.views = views;
        }
        public String getReplies() {
            return replies;
        }
        public void setReplies(String replies) {
            this.replies = replies;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }

        public Created getCreated() {
            return created;
        }

        public void setCreated(Created created) {
            this.created = created;
        }

        public Updated getUpdated() {
            return updated;
        }

        public void setUpdated(Updated updated) {
            this.updated = updated;
        }
        public String getPublished() {
            return published;
        }
        public void setPublished(String published) {
            this.published = published;
        }
        public User getUser() {
            return user;
        }
        public void setUser(User user) {
            this.user = user;
        }
        public Comment getComment() {
            return comment;
        }
        public void setComment(Comment comment) {
            this.comment = comment;
        }
    }

    private class Datum_ {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("likes")
        @Expose
        private Integer likes;
        @SerializedName("dislikes")
        @Expose
        private Integer dislikes;
        @SerializedName("shares")
        @Expose
        private Integer shares;
        @SerializedName("user")
        @Expose
        private User_ user;
        @SerializedName("views")
        @Expose
        private String views;
        @SerializedName("created")
        @Expose
        private Created_ created;
        @SerializedName("updated")
        @Expose
        private Updated_ updated;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
        public String getSlug() {
            return slug;
        }
        public void setSlug(String slug) {
            this.slug = slug;
        }
        public Integer getLikes() {
            return likes;
        }
        public void setLikes(Integer likes) {
            this.likes = likes;
        }
        public Integer getDislikes() {
            return dislikes;
        }
        public void setDislikes(Integer dislikes) {
            this.dislikes = dislikes;
        }
        public Integer getShares() {
            return shares;
        }
        public void setShares(Integer shares) {
            this.shares = shares;
        }
        public User_ getUser() {
            return user;
        }
        public void setUser(User_ user) {
            this.user = user;
        }
        public String getViews() {
            return views;
        }
        public void setViews(String views) {
            this.views = views;
        }
        public Created_ getCreated() {
            return created;
        }
        public void setCreated(Created_ created) {
            this.created = created;
        }
        public Updated_ getUpdated() {
            return updated;
        }
        public void setUpdated(Updated_ updated) {
            this.updated = updated;
        }
    }

    private class Links {
        @SerializedName("next")
        @Expose
        private String next;
        public String getNext() {
            return next;
        }
        public void setNext(String next) {
            this.next = next;
        }
    }

    private class Meta {
        @SerializedName("pagination")
        @Expose
        private Pagination pagination;
        public Pagination getPagination() {
            return pagination;
        }
        public void setPagination(Pagination pagination) {
            this.pagination = pagination;
        }
    }

    private class Pagination {
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("per_page")
        @Expose
        private Integer perPage;
        @SerializedName("current_page")
        @Expose
        private Integer currentPage;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("links")
        @Expose
        private Links links;
        public Integer getTotal() {
            return total;
        }
        public void setTotal(Integer total) {
            this.total = total;
        }
        public Integer getCount() {
            return count;
        }
        public void setCount(Integer count) {
            this.count = count;
        }
        public Integer getPerPage() {
            return perPage;
        }
        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }
        public Integer getCurrentPage() {
            return currentPage;
        }
        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }
        public Integer getTotalPages() {
            return totalPages;
        }
        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }
        public Links getLinks() {
            return links;
        }
        public void setLinks(Links links) {
            this.links = links;
        }
    }

    private class Updated {
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private Integer timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public Integer getTimezoneType() {
            return timezoneType;
        }
        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }
        public String getTimezone() {
            return timezone;
        }
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    private class Updated_ {
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("timezone_type")
        @Expose
        private Integer timezoneType;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public Integer getTimezoneType() {
            return timezoneType;
        }
        public void setTimezoneType(Integer timezoneType) {
            this.timezoneType = timezoneType;
        }
        public String getTimezone() {
            return timezone;
        }
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    private class User {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("vanity")
        @Expose
        private String vanity;
        @SerializedName("avatarUrl")
        @Expose
        private String avatarUrl;
        @SerializedName("profileUrl")
        @Expose
        private String profileUrl;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getVanity() {
            return vanity;
        }
        public void setVanity(String vanity) {
            this.vanity = vanity;
        }
        public String getAvatarUrl() {
            return avatarUrl;
        }
        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
        public String getProfileUrl() {
            return profileUrl;
        }
        public void setProfileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
        }
    }

    private class User_ {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("vanity")
        @Expose
        private String vanity;
        @SerializedName("avatarUrl")
        @Expose
        private String avatarUrl;
        @SerializedName("profileUrl")
        @Expose
        private String profileUrl;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getVanity() {
            return vanity;
        }
        public void setVanity(String vanity) {
            this.vanity = vanity;
        }
        public String getAvatarUrl() {
            return avatarUrl;
        }
        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
        public String getProfileUrl() {
            return profileUrl;
        }
        public void setProfileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
        }
    }





}
