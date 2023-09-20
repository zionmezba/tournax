package com.tournax.pck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;
import java.util.List;

public class Home_page extends AppCompatActivity{

    ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    AdapterCard adapterCard;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ViewPager viewpager3;
    TextView txtv = (TextView) findViewById(R.id.username_hometext);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Main Code
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null) {
            txtv.setText(signInAccount.getDisplayName());
        }

        //Menu Buttons
        Button mb1 = (Button) findViewById(R.id.profile_btn);
        Button mb2 = (Button) findViewById(R.id.inbox_btn);
        Button mb3 = (Button) findViewById(R.id.gallery_btn);
        Button mb4 = (Button) findViewById(R.id.rank_btn);
        Button setting = (Button) findViewById(R.id.settings_btn);
        ImageView tx_image = (ImageView) findViewById(R.id.tx_icon_button);

        tx_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutus();
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInbox();
            }
        });
        mb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        mb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRank();
            }
        });

        //Slider1
        viewPager2 = findViewById(R.id.eventImageSlider);  //Hook
        List<SliderItem> sliderItems = new ArrayList<>();

        sliderItems.add(new SliderItem(R.drawable.sliderimg1));
        sliderItems.add(new SliderItem(R.drawable.sliderimg2));
        sliderItems.add(new SliderItem(R.drawable.sliderimg3));
        sliderItems.add(new SliderItem(R.drawable.sliderimg4));
        sliderItems.add(new SliderItem(R.drawable.sliderimg5));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        //Slider 2
        viewpager3 = findViewById(R.id.createSlider);
        AdapterCard adapterCard = new AdapterCard(this);
        viewpager3.setAdapter(adapterCard);

        viewpager3.setClipToPadding(false);
        viewpager3.setClipChildren(false);
        viewpager3.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    public void openCreate_T() {
        Intent intent = new Intent(this, Create_Tournament.class);
        startActivity(intent);
    }

    public void openProfile() {
        Intent intent = new Intent(this, Profile_activity.class);
        startActivity(intent);
    }

    public void openInbox() {
        Intent intent = new Intent(this, Inbox_activity.class);
        startActivity(intent);
    }

    public void openGallery() {
        Intent intent = new Intent(this, Gallery_activity.class);
        startActivity(intent);
    }

    public void openRank() {
        Intent intent = new Intent(this, Rank_activity.class);
        startActivity(intent);
    }

    public void openAboutus(){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
