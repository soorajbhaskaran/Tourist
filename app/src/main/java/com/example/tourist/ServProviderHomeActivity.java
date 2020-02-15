package com.example.tourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ServProviderHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serv_provider_home);
        Toast.makeText(this, getIntent().getExtras().getString("email"), Toast.LENGTH_SHORT).show();
    }
}
