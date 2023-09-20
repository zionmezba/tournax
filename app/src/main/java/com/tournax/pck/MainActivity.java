package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Variable

    Animation circleAnim, tournaxAnim, fullTXanim;
    ImageView circle, logo, fullLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Main Code
        //Animation
        circleAnim = AnimationUtils.loadAnimation(this,R.anim.start_circle_animation);
        tournaxAnim = AnimationUtils.loadAnimation(this,R.anim.start_tournax_amination);
        fullTXanim = AnimationUtils.loadAnimation(this,R.anim.start_fulltx_animation);

        //Hook
        circle = findViewById(R.id.circle_loading);
        logo = findViewById(R.id.x_loading);
        fullLogo = findViewById(R.id.fullTxLogo02);

        circle.setAnimation(circleAnim);
        logo.setAnimation(tournaxAnim);
        fullLogo.setAnimation(fullTXanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}