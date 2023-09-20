package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rank_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_activity);

        //Main Code
        Button back = (Button) findViewById(R.id.rback_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }
    public void goBack()
    {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }
}