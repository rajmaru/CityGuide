package com.one.cityguide.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.one.cityguide.R;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.sliderViewholder>{

    Context context;
    ArrayList<Sliderdata> sliderdata;
    int lastPosition;

    public SliderAdapter(Context context, ArrayList<Sliderdata> sliderdata) {
        this.context = context;
        this.sliderdata = sliderdata;
    }

    @NonNull
    @Override
    public sliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_layout,parent, false);
        return new sliderViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sliderViewholder holder, int position) {
        Sliderdata sliderdata = this.sliderdata.get(position);
        lastPosition = this.sliderdata.size() - 1;
        holder.sliderImage.setImageResource(sliderdata.getImage());
        holder.sliderTitle.setText(sliderdata.getTitle());
    }

    @Override
    public int getItemCount() {
        return sliderdata.size();
    }


    public static class sliderViewholder extends RecyclerView.ViewHolder{

        ImageView sliderImage;
        TextView sliderTitle;
        
        public sliderViewholder(@NonNull View itemView) {
            super(itemView);
            sliderImage = itemView.findViewById(R.id.slider_image);
            sliderTitle = itemView.findViewById(R.id.slider_title);
        }
    }
}
