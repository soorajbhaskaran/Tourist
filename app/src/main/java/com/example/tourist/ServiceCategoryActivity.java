package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ServiceCategoryActivity extends Activity {

    ServiceProviderAdapter servProvAdapter;
    List<ServProvider> servProviderList;
    RecyclerView servProvListView;
    String category;
    TextView servCatTitle, servCatSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_category);
        category = getIntent().getExtras().getString("category");


        servProvListView = findViewById(R.id.serviceProviderListView);
        servCatTitle = findViewById(R.id.servCatTitle);
        servCatTitle = findViewById(R.id.servCatTitle);

        servCatTitle.setText(category);

        servProviderList = new ArrayList<>();
        servProvAdapter = new ServiceProviderAdapter(servProviderList, this);
        servProvListView.setAdapter(servProvAdapter);
        servProvListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        servProvListView.setItemAnimator(new DefaultItemAnimator());
        prepareServProvList();



    }

    private void prepareServProvList() {
        ServProvider servProvider = new ServProvider();
        servProviderList.add(servProvider);
        servProviderList.add(servProvider);
        servProviderList.add(servProvider);
        servProviderList.add(servProvider);
        servProviderList.add(servProvider);
        servProviderList.add(servProvider);
        servProvAdapter.notifyDataSetChanged();
    }
}
