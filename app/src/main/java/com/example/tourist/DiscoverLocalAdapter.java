package com.example.tourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiscoverLocalAdapter extends  RecyclerView.Adapter<DiscoverLocalAdapter.DiscoverViewHolder>{
    List<Story> storyList;
    Context context;
    public DiscoverLocalAdapter(List<Story> storyList, Context context){
        this.storyList = storyList;
        this.context = context;
    }
    @NonNull
    @Override
    public DiscoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discover_layout, parent, false);
        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.storyImg.setImageResource(R.drawable.eve);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class DiscoverViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImg;
        public DiscoverViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImg = itemView.findViewById(R.id.storyImg);
        }
    }
}
