package com.marimakter.bigbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myywebview = (WebView)findViewById(R.id.Webb);
        WebSettings webSettings = myywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myywebview.loadUrl("https://bigbuy123.000webhostapp.com/?fbclid=IwAR13I4flROVe8m2oP7rsIYQwZjhzz60HF5_3dIGETiNk0o_LsV8DrRklnFc");
        myywebview.setWebViewClient(new WebViewClient());


    }
    @Override
    public void onBackPressed(){
        if(myywebview.canGoBack()){
            myywebview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

}
