package com.one.cityguide.Categories;

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

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{

    Context context;
    ArrayList<CategoriesData> categoriesDataList;

    public CategoriesAdapter(Context context, ArrayList<CategoriesData> categoriesDataList) {
        this.context = context;
        this.categoriesDataList = categoriesDataList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_sample_layout,parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesData categoriesData = categoriesDataList.get(position);
        holder.title.setText(categoriesData.getTitle());
        holder.image.setImageResource(categoriesData.getImage());
    }

    @Override
    public int getItemCount() {
        return categoriesDataList.size();
    }


    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView image;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.categories_title);
            image = itemView.findViewById(R.id.categories_image);
        }
    }
}
