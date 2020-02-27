package com.example.tourist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity implements View.OnClickListener {

    TrendingLocalAdapter trendingAdapter;
    DiscoverLocalAdapter discoverAdapter;
    List<Story> trendingStoryList, discoverStoryList;
    ImageView searchIcon;

    RecyclerView trendingLocalListView, discoverLocalListView;
    LinearLayout homeExploreBtn;
    ImageView homeExploreIcon;
    TextView homeExploreTxt;
    LinearLayout homeFollowBtn;
    ImageView homeFollowIcon;
    TextView homeFollowTxt;
    LinearLayout homeProfileBtn;
    ImageView homeProfileIcon;
    TextView homeProfileTxt;
    LinearLayout homeExploreSec, homeProfileSec;
    DatabaseReference databaseReference;

    private String currentCity = "Thrissur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseReference = FirebaseDatabase.getInstance().getReference(getString(R.string.servProviderTable));

        trendingLocalListView = findViewById(R.id.trendingLocalList);
        discoverLocalListView = findViewById(R.id.discoverLocalList);
        searchIcon = findViewById(R.id.searchServices);

        homeExploreSec = findViewById(R.id.homeExploreSec);
        homeProfileSec = findViewById(R.id.homeProfileSec);

        homeExploreIcon = findViewById(R.id.homeExploreIcon);
        homeExploreTxt = findViewById(R.id.homeExploreTxt);
        homeExploreBtn = findViewById(R.id.homeExploreBtn);

        homeFollowIcon = findViewById(R.id.homeFollowIcon);
        homeFollowTxt = findViewById(R.id.homeFollowTxt);
        homeFollowBtn = findViewById(R.id.homeFollowBtn);

        homeProfileBtn = findViewById(R.id.homeProfileBtn);
        homeProfileIcon = findViewById(R.id.homeProfileIcon);
        homeProfileTxt = findViewById(R.id.homeProfileTxt);


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

        setCurrentMenu(0);

        searchIcon.setOnClickListener(this);
        homeExploreBtn.setOnClickListener(this);
        homeFollowBtn.setOnClickListener(this);
        homeProfileBtn.setOnClickListener(this);
    }

    private void setCurrentMenu(int position) {
        switch (position){
            case 0:
                showExploreSec();
                break;
            case 1:
                showFollowSec();
                break;
            case 2:
                showProfileSec();
                break;
        }
    }

    private void showProfileSec() {
        hideAll();
        homeProfileIcon.setColorFilter(getResources().getColor(R.color.colorAccent));
        homeProfileTxt.setTextColor(getResources().getColor(R.color.colorAccent));

        homeProfileSec.setVisibility(View.VISIBLE);
    }

    private void showFollowSec() {
        hideAll();
        homeFollowIcon.setColorFilter(getResources().getColor(R.color.colorAccent));
        homeFollowTxt.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    private void showExploreSec() {
        hideAll();
        homeExploreIcon.setColorFilter(getResources().getColor(R.color.colorAccent));
        homeExploreTxt.setTextColor(getResources().getColor(R.color.colorAccent));

        homeExploreSec.setVisibility(View.VISIBLE);
    }

    private void hideAll(){
        homeExploreIcon.setColorFilter(getResources().getColor(R.color.colorDisabledAccent));
        homeExploreTxt.setTextColor(getResources().getColor(R.color.colorDisabledAccent));
        homeFollowIcon.setColorFilter(getResources().getColor(R.color.colorDisabledAccent));;
        homeFollowTxt.setTextColor(getResources().getColor(R.color.colorDisabledAccent));
        homeProfileIcon.setColorFilter(getResources().getColor(R.color.colorDisabledAccent));
        homeProfileTxt.setTextColor(getResources().getColor(R.color.colorDisabledAccent));

        homeExploreSec.setVisibility(View.GONE);
        homeProfileSec.setVisibility(View.GONE);
    }

    private void prepareDiscoverStories() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() < 1){
                    Toast.makeText(HomeActivity.this, "No service providers available", Toast.LENGTH_SHORT).show();
                    return;
                }
                discoverStoryList.clear();
                for(DataSnapshot snap: dataSnapshot.getChildren()){
                    ServProvider servProvider = snap.getValue(ServProvider.class);
                    if (servProvider == null)
                        continue;
                    if (servProvider.getCity().equals(currentCity)){
                        Story story = new Story(servProvider.getName(),"", servProvider.getDesc(), servProvider.getEmail());
                        discoverStoryList.add(story);
                    }
                }
                discoverAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this, "Something went wrong. Try again later", Toast.LENGTH_SHORT).show();
            }
        });
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
            case R.id.homeExploreBtn:
                setCurrentMenu(0);
                break;
            case R.id.homeFollowBtn:
                setCurrentMenu(1);
                break;
            case R.id.homeProfileBtn:
                setCurrentMenu(2);
                break;
        }
    }
}
