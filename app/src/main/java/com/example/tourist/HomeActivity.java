package com.example.tourist;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity implements View.OnClickListener {

    TrendingLocalAdapter trendingAdapter;
    DiscoverLocalAdapter discoverAdapter;
    List<Story> trendingStoryList, discoverStoryList;
    ImageView searchIcon;

    RecyclerView trendingLocalListView, discoverLocalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        trendingLocalListView = findViewById(R.id.trendingLocalList);
        discoverLocalListView = findViewById(R.id.discoverLocalList);
        searchIcon = findViewById(R.id.searchServices);

        trendingStoryList = new ArrayList<>();
        discoverStoryList = new ArrayList<>();

        trendingAdapter = new TrendingLocalAdapter(trendingStoryList, this);
        trendingLocalListView.setAdapter(trendingAdapter);
        trendingLocalListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trendingLocalListView.setItemAnimator(new DefaultItemAnimator());
        prepareTrendingStories();

        discoverAdapter = new DiscoverLocalAdapter(discoverStoryList, this);
        discoverLocalListView.setAdapter(discoverAdapter);
        discoverLocalListView.setLayoutManager(new GridLayoutManager(this, 2));
        discoverLocalListView.setItemAnimator(new DefaultItemAnimator());
        prepareDiscoverStories();

        searchIcon.setOnClickListener(this);
    }

    private void prepareDiscoverStories() {
        Story story = new Story();
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverStoryList.add(story);
        discoverAdapter.notifyDataSetChanged();
    }


    private void prepareTrendingStories() {
        Story story = new Story();
        trendingStoryList.add(story);
        trendingStoryList.add(story);
        trendingStoryList.add(story);
        trendingStoryList.add(story);
        trendingStoryList.add(story);
        trendingStoryList.add(story);
        trendingAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.searchServices:
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
