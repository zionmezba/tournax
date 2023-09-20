package com.tournax.pck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SlideViewHolder>{

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;
    Context context;
    private LayoutInflater layoutInflater;

    SliderAdapter(List<SliderItem> sliderItemlist, ViewPager2 viewPager2) {
        this.sliderItems = sliderItemlist;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.containerimage_layout,
                        parent,
                        false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
    holder.setImage(sliderItems.get(position));
    if(position == sliderItems.size() - 2)
    {
        viewPager2.post(runnable);
    }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagSlide);
        }

        void setImage(SliderItem sliderItem)
        {
            imageView.setImageResource(sliderItem.getImage());
        }
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

}
