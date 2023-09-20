package com.tournax.pck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Signin extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null)
        {
            Intent intent = new Intent(Signin.this,Home_page.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);

        //Main Code
        mAuth = FirebaseAuth.getInstance();
        Button signin = (Button)findViewById(R.id.signin_button02);
        ImageView gglSignin = (ImageView) findViewById(R.id.google_lgin);
        final EditText et_name = (EditText)findViewById(R.id.username_signin);
        final EditText et_pass = (EditText)findViewById(R.id.password_signin);
        createRequest();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l_user = et_name.getText().toString();
                String l_password = et_pass.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);

                String reg_user = preferences.getString("username", "");
                String reg_pass = preferences.getString("password", "");

                if(l_user.equals(reg_user) && l_password.equals(reg_pass))
                {
                    Intent intent = new Intent(Signin.this,Home_page.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(Signin.this,"Wrong username or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gglSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void createRequest(){
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Toast.makeText(this,"Authentication Success!",Toast.LENGTH_SHORT).show();
                firebaseAuthWithGoogle(account.getIdToken());
            }
            catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this,"Authentication Failed!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Signin.this,Home_page.class);
                            Toast.makeText(Signin.this, "Success! ", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(Signin.this, "Oh! Authentication Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}