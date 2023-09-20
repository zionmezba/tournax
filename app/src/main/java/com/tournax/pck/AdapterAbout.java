package com.tournax.pck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdapterAbout extends PagerAdapter {

    List<Names> namelist;
    Context context;
    LayoutInflater layoutInflater;

    public AdapterAbout(Context context,List<Names> namelist) {
        this.namelist = namelist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false);
        ImageView name_image = (ImageView) view.findViewById(R.id.our_images);
        TextView name_title = (TextView) view.findViewById(R.id.name_title);
        TextView name_desc = (TextView) view.findViewById(R.id.name_desc);
        FloatingActionButton fav_btn = (FloatingActionButton) view.findViewById(R.id.fav_btn);
        name_image.setImageResource(namelist.get(position).getImage());
        name_title.setText(namelist.get(position).getName());
        name_desc.setText(namelist.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+namelist.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Thanks For Your Love!",Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }
}
