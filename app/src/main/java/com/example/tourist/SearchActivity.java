package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {

    ArrayAdapter searchAdapter;
    private List<String> serviceCategories;
    private ListView searchCategoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchCategoriesList = findViewById(R.id.service_category_list);
        serviceCategories = new ArrayList<>();
        prepareCategories();
        searchAdapter = new ArrayAdapter(this, R.layout.service_list_item, R.id.searchCategoryTxt, serviceCategories);
        searchCategoriesList.setAdapter(searchAdapter);

        searchCategoriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cat = serviceCategories.get(i);
                // show page of this category

            }
        });
    }

    private void prepareCategories(){
        serviceCategories.add("Stay");
        serviceCategories.add("Food");
        serviceCategories.add("Entertainments");
        serviceCategories.add("Artifacts");
    }
}
