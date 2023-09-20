package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_form);

        //Main Code
        Button back = (Button) findViewById(R.id.joinFormBack);
        Button home = (Button) findViewById(R.id.joinFormHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohome();
            }
        });
    }

    public void goBack()
    {
        Intent intent = new Intent(this,JoinTournament.class);
        startActivity(intent);
    }

    public void gohome()
    {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

}