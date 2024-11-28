package com.example.car_app2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.car_app2.Activity.login;
import com.example.car_app2.Adapter.PopularAdapter;
import com.example.car_app2.R;
import com.example.car_app2.databinding.ActivityMainBinding;
import com.example.car_app2.domain.PopularDomain;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private Button button;
    private TextView textView;

    private ActivityMainBinding binding;

    private FusedLocationProviderClient fusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //map


        // Use view binding to initialize the layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize RecyclerView
        initRecycleView();

        // Set up Firebase Authentication
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // Set up user details and logout button functionality
        textView = binding.userDetails;
        button = binding.logout;

        // Check if the user is authenticated
        if (user == null) {
            // If not authenticated, redirect to login screen
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        } else {
            // If authenticated, show user email
            textView.setText(user.getEmail());
        }

        // Set up logout functionality
        button.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        });
    }

    private void statusBarColor(){
        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.darkYellow));
    }

    // Initialize RecyclerView with sample data
    private void initRecycleView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Mercedes Benz", "@drawable/item1", 25000,""));
        items.add(new PopularDomain("Porshe", "@drawable/item2", 30000,""));
        items.add(new PopularDomain("Rols Royes", "@drawable/item3", 35000,""));
        items.add(new PopularDomain("BMW", "@drawable/item4", 35000,""));

        // Set up RecyclerView with Horizontal LayoutManager
        binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}
