package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinTournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_tournament);

        //Main Code
        Button back = (Button) findViewById(R.id.backBtnjoinAndroidForm);
        Button home = (Button) findViewById(R.id.joinandroidhomebtn);
        Button pubg = (Button) findViewById(R.id.pubgmobobtn);
        Button cod = (Button) findViewById(R.id.codmoboBtn);
        Button frf = (Button) findViewById(R.id.freefireBtn);

        pubg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinTournament.this,JoinForm.class));
            }
        });
        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinTournament.this,JoinForm.class));
            }
        });
        frf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinTournament.this,JoinForm.class));
            }
        });
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
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

    public void gohome()
    {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }
}
