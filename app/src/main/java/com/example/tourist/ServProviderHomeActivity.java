package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ServProviderHomeActivity extends Activity {

    private TextView businessName, businessAddress;
    private RadioGroup businessOptionsSec;
    private RecyclerView commonListView;
    private List<ProvidedServices> servicesList;
    private List<CustomerReview> reviewList;
    private ServicesAdapter servicesAdapter;
    private ReviewAdapter reviewAdapter;
    private DatabaseReference servProvDbReference;
    private SessionManager sessionManager;
    private ServProvider servProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serv_provider_home);
        Toast.makeText(this, getIntent().getExtras().getString("email"), Toast.LENGTH_SHORT).show();

        servProvDbReference = FirebaseDatabase.getInstance().getReference(getString(R.string.servProviderTable));
        sessionManager = new SessionManager(this);
        servProvider = sessionManager.getServiceProvider();
        servicesList = new ArrayList<>();
        reviewList = new ArrayList<>();
        servicesAdapter = new ServicesAdapter(servicesList, this);
        reviewAdapter = new ReviewAdapter(this, reviewList);

        businessName = findViewById(R.id.servProvName);
        businessAddress = findViewById(R.id.servProvAddress);
        commonListView = findViewById(R.id.commonListView);
        businessOptionsSec = findViewById(R.id.businessOptionsSec);

// set services adapter
        servicesAdapter = new ServicesAdapter(servicesList, this, servProvider);
        commonListView.setAdapter(servicesAdapter);
        commonListView.setLayoutManager(new LinearLayoutManager(this));
        commonListView.setItemAnimator(new DefaultItemAnimator());

        businessName.setText(servProvider.getName());
        businessAddress.setText(servProvider.getAddress());

    }
}
