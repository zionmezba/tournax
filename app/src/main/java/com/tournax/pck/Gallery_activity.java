package com.tournax.pck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Gallery_activity extends AppCompatActivity {

    WebView gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_activity);

        //Main Code
        gallery = (WebView) findViewById(R.id.gallery_webview); //Hook

        gallery.setWebViewClient(new WebViewClient());
        gallery.loadUrl("https://www.youtube.com/GameXen");

        WebSettings webSettings =  gallery.getSettings();
        webSettings.setJavaScriptEnabled(true);
        gallery.setWebChromeClient(new WebChromeClient());

        Button back = (Button) findViewById(R.id.gback_button);
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

    @Override
    public void onBackPressed() {
        if(gallery.canGoBack()) {
            gallery.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}