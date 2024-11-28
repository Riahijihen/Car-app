package com.example.car_app2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.Glide;
import com.example.car_app2.R;
import com.example.car_app2.databinding.ActivityDetail2Binding;
import com.example.car_app2.domain.PopularDomain;

public class DetailActivity2 extends AppCompatActivity {
    private ActivityDetail2Binding binding;
    private PopularDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetail2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());  // Correct way to set content view

        getBundles();
    }

    private void getBundles() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");

        // Ensure object is not null
        if (object != null) {
            Log.d("DetailActivity", "Received object: " + object.getTitle());

            int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

            // Check if drawable resource ID is valid
            if (drawableResourceId != 0) {
                Glide.with(this)
                        .load(drawableResourceId)
                        .into(binding.itemPic);
            }

            // Set title, price, and description with null checks
            if (object.getTitle() != null) {
                binding.titleTxt.setText(object.getTitle());
            }

            if (object.getPrice() != 0) {
                binding.priceTxt.setText("DT" + object.getPrice());
            }

            if (object.getDescription() != null) {
                binding.descriptionTxt.setText(object.getDescription());
            }

            binding.addToCardBtn.setOnClickListener(v -> {
                // Implement functionality for Add to Cart button
            });
        } else {
            Log.e("DetailActivity", "Object is null");
        }
    }
}
