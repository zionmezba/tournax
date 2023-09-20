package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    Animation circleAnim2, signupamin, signinanim;
    ImageView logo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Main Code
        Button login_b = findViewById(R.id.login_button);
        Button signin_b = findViewById(R.id.sign_in);

        signin_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignin();
                finish();
            }
        });

        login_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
                finish();
            }
        });

        //Animation
        circleAnim2 = AnimationUtils.loadAnimation(this,R.anim.start_circle_animation);
        signinanim = AnimationUtils.loadAnimation(this,R.anim.lefttright_transition);
        signupamin = AnimationUtils.loadAnimation(this,R.anim.righttoleft_transition);
        logo = findViewById(R.id.logo_dashboard);
        login_b.setAnimation(signinanim);
        signin_b.setAnimation(signupamin);
        logo.setAnimation(circleAnim2);


    }
    public void openSignin()
    {
        Intent intent = new Intent(this,Signin.class);
        startActivity(intent);
    }
    public void openSignUp()
    {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}