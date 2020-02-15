package com.example.tourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrendingLocalAdapter  extends  RecyclerView.Adapter<TrendingLocalAdapter.LocalViewHolder>  {

    List<Story> storyList;
    Context context;
    public TrendingLocalAdapter(List<Story> storyList, Context context){
        this.storyList = storyList;
        this.context = context;
    }
    @NonNull
    @Override
    public TrendingLocalAdapter.LocalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_layout, parent, false);
        return new LocalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingLocalAdapter.LocalViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.storyImg.setImageResource(R.drawable.eve);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class LocalViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImg;
        public LocalViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImg = itemView.findViewById(R.id.storyImg);
        }
    }
}
