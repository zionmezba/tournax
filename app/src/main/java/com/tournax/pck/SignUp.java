package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_sign_up);

        //Main Code


        //Hooking
        Button sup = findViewById(R.id.signup_button);
        final EditText user = (EditText)findViewById(R.id.username_signup);
        final EditText full_name = (EditText)findViewById(R.id.full_name);
        final EditText pnum1 = (EditText)findViewById(R.id.phone_number);
        final EditText mail = (EditText)findViewById(R.id.email_addr);
        final EditText country1 = (EditText)findViewById(R.id.country_name);
        final EditText pass = (EditText)findViewById(R.id.password);
        final EditText interests = (EditText)findViewById(R.id.interested_games);

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //Get Val
                String name = full_name.toString();
                String userName = user.toString();
                String phone = pnum1.toString();
                String email = mail.toString();
                String country = country1.toString();
                String password =pass.toString();
                String interest = interests.toString();

                UserHelperClass helperClass = new UserHelperClass(name,phone,email,country,userName,password,interest);
                reference.child(phone).setValue(helperClass);

                Toast.makeText(SignUp.this,"Registration Success!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SignUp.this, Dashboard.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}