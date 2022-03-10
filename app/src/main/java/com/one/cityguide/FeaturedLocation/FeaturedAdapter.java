package com.one.cityguide.FeaturedLocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.one.cityguide.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedHolder>{

    Context context;
    ArrayList<FeaturedData> featuredDataList;

    public FeaturedAdapter(Context context, ArrayList<FeaturedData> featuredDataList) {
        this.context = context;
        this.featuredDataList = featuredDataList;
    }

    @NonNull
    @Override
    public FeaturedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.featured_sample_layout, parent, false);
        return new FeaturedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedHolder holder, int position) {
        FeaturedData featuredData = featuredDataList.get(position);
        holder.image.setImageResource(featuredData.getImage());
        holder.title.setText(featuredData.getTitle());
        holder.description.setText(featuredData.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredDataList.size();
    }


    public static class FeaturedHolder extends RecyclerView.ViewHolder{

        TextView title, description;
        ImageView image;

        public FeaturedHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_card_image);
            title = itemView.findViewById(R.id.featured_card_title);
            description = itemView.findViewById(R.id.mostviewed_description);
        }
    }
}
