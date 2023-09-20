package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_Tournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__tournament);

        //Main Code
        //Hook
        Button cback = findViewById(R.id.createBack);
        Button chome = findViewById(R.id.createHome);
        Button btn = findViewById(R.id.nextBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Create_Tournament.this,Create_Tournament2.class));
            }
        });

        cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Create_Tournament.this,Home_page.class));
            }
        });
        chome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Create_Tournament.this,Home_page.class));
            }
        });
    }
}