package com.tournax.pck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class AdapterCard extends PagerAdapter {

    private List<Model>models;
    private LayoutInflater layoutInflater;
    private Context context;
    private Integer[] images = {R.drawable.tile_01,R.drawable.tile_02,R.drawable.tile_03};

    public AdapterCard(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.myimageview);
        imageView.setImageResource(images[position]);
        ViewPager vpg = (ViewPager) container;
        vpg.addView(view);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0)
                {
                    Intent myTour = new Intent(v.getContext(),MyTournaments.class);
                    v.getContext().startActivity(myTour);
                }
                else if(position == 1)
                {
                    Intent jTour = new Intent(v.getContext(),JoinTournament.class);
                    v.getContext().startActivity(jTour);
                }
                else if(position == 2)
                {
                    Intent cTour = new Intent(v.getContext(),Create_Tournament.class);
                    v.getContext().startActivity(cTour);
                }

            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
