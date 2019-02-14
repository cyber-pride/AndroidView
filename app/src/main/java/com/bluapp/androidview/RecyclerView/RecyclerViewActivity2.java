package com.bluapp.androidview.RecyclerView;

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

import com.bluapp.androidview.Chat;
import com.bluapp.androidview.R;
import com.bluapp.androidview.Video;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity2 extends AppCompatActivity {
    private RecyclerView list;
    private adapter recyclerAdapter;
    private final static int TYPE_CHAT=1,TYPE_VIDEO=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);
        list = (RecyclerView) findViewById(R.id.list);

        //Data
        ArrayList<Object> chatsList = new ArrayList<>();
        chatsList.add(new Chat("Nurat","1:00 AM"));
        chatsList.add(new Chat("Wisdom","2:00 AM"));
        chatsList.add(new Chat("Tope","3:00 AM"));
        chatsList.add(new Video("Tope","Lagos","3:30 AM"));
        chatsList.add(new Chat("Peter","4:00 AM"));
        chatsList.add(new Chat("Ayomide","5:00 AM"));
        chatsList.add(new Chat("Korede","6:00 AM"));
        chatsList.add(new Chat("Wizkid","7:00 AM"));
        chatsList.add(new Video("Wizkid","Abuja","7:05 AM"));
        chatsList.add(new Video("Wizkid","Abuja","7:10 AM"));
        chatsList.add(new Chat("Davido","8:00 AM"));
        chatsList.add(new Chat("Olamide","9:00 AM"));
        chatsList.add(new Chat("Funke","10:00 AM"));
        chatsList.add(new Video("Funke","Sweden","10:10 AM"));
        chatsList.add(new Chat("Samuel","11:00 AM"));
        chatsList.add(new Chat("Opeyemi","12:00 AM"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        recyclerAdapter = new adapter(RecyclerViewActivity2.this, chatsList);
        list.setAdapter(recyclerAdapter);
    }


    private class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        List<Object> mData;

        public adapter(Context context, List<Object> data) {
            this.context = context;
            this.mData = data;
        }

        public int getItemViewType(int position) {
            if (mData.get(position) instanceof Chat) {
                return TYPE_CHAT;
            } else if (mData.get(position) instanceof Video) {
                return TYPE_VIDEO;
            }
            return -1;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layout = 0;
            RecyclerView.ViewHolder viewHolder;
            switch (viewType){
                case TYPE_CHAT:
                    layout=R.layout.recyclerview_adapterchat;
                    View chatView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                    viewHolder=new ChatViewHolder(chatView);
                    break;
                case TYPE_VIDEO:
                    layout=R.layout.recyclerview_adapter2;
                    View videoView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
                    viewHolder=new VideoViewHolder(videoView);
                    break;
                default:
                    viewHolder=null;
                    break;
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int viewType=holder.getItemViewType();
            switch (viewType){
                case TYPE_CHAT:
                    Chat chat = (Chat)mData.get(position);
                    ((ChatViewHolder)holder).showDetails(chat);
                    break;
                case TYPE_VIDEO:
                    Video video = (Video) mData.get(position);
                    ((VideoViewHolder)holder).showDetails(video);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class ChatViewHolder extends RecyclerView.ViewHolder {
            private TextView userNameTextView,TimeTextView;
            public ChatViewHolder(View itemView) {
                super(itemView);
                // Initiate view
                userNameTextView=(TextView)itemView.findViewById(R.id.userName);
                TimeTextView=(TextView)itemView.findViewById(R.id.Time);
            }
            public void showDetails(Chat chat){
                // Attach values for each item
                String userName = chat.getUserName();
                String Time = chat.getTime();
                userNameTextView.setText(userName);
                TimeTextView.setText(Time);
            }
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTextView,PlaceTextView, TimeTextView;
        public VideoViewHolder(View itemView) {
            super(itemView);
            userNameTextView =(TextView)itemView.findViewById(R.id.userName);
            PlaceTextView =(TextView)itemView.findViewById(R.id.place);
            TimeTextView =(TextView)itemView.findViewById(R.id.videoTime);
        }
        public void showDetails(Video video){
            String userName = video.getuserName();
            String videoPlace = video.getPlace();
            String videoTime = video.getTime();
            userNameTextView.setText(userName);
            PlaceTextView.setText(videoPlace);
            TimeTextView.setText(videoTime);
        }
    }





}
