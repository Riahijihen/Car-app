package com.example.car_app2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.car_app2.Activity.DetailActivity2;
import com.example.car_app2.databinding.ViewholderPupListBinding;
import com.example.car_app2.domain.PopularDomain;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    private ArrayList<PopularDomain> items;
    private Context context;

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderPupListBinding binding = ViewholderPupListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        PopularDomain currentItem = items.get(position);

        // Set title and price with null checks
        if (currentItem.getTitle() != null) {
            holder.binding.titletxt.setText(currentItem.getTitle());
        }

        if (currentItem.getPrice() != 0) {
            holder.binding.price.setText(currentItem.getPrice() + " DT");
        }

        // Load image with Glide and apply rounded corners
        int drawableResId = holder.itemView.getResources().getIdentifier(currentItem.getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        if (drawableResId != 0) {
            Glide.with(context)
                    .load(drawableResId)
                    .transform(new GranularRoundedCorners(30, 30, 0, 0))
                    .into(holder.binding.pic);
        }

        // Set OnClickListener for item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity2.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        private final ViewholderPupListBinding binding;

        public Viewholder(ViewholderPupListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
