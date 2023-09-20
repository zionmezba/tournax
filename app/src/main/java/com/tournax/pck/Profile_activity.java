package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

public class Profile_activity extends AppCompatActivity {
    TextView txtv2 = (TextView) findViewById(R.id.username_profile);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Main Code
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null) {
            txtv2.setText(signInAccount.getDisplayName());
        }

        Button balance = (Button) findViewById(R.id.balance_btn);
        Button back = (Button) findViewById(R.id.p_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWallet();
            }
        });

    }
    public void goBack()
    {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

    public void goWallet()
    {
        Intent intent = new Intent(this,Wallet.class);
        startActivity(intent);
    }
}