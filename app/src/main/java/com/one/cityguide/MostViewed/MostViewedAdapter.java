package com.one.cityguide.MostViewed;

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

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedHolder>{

    Context context;
    ArrayList<MostViewedData> mostViewedDataList;

    public MostViewedAdapter(Context context, ArrayList<MostViewedData> mostViewedDataList) {
        this.context = context;
        this.mostViewedDataList = mostViewedDataList;
    }

    @NonNull
    @Override
    public MostViewedAdapter.MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mostviewed_sample_layout, parent, false);
        return new MostViewedAdapter.MostViewedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedAdapter.MostViewedHolder holder, int position) {
        MostViewedData mostViewedData = mostViewedDataList.get(position);
        holder.image.setImageResource(mostViewedData.getImage());
        holder.title.setText(mostViewedData.getTitle());
        holder.description.setText(mostViewedData.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostViewedDataList.size();
    }


    public static class MostViewedHolder extends RecyclerView.ViewHolder{

        TextView title, description;
        ImageView image;

        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mostviewed_image);
            title = itemView.findViewById(R.id.mostviewed_title);
            description = itemView.findViewById(R.id.mostviewed_description);
        }
    }
}