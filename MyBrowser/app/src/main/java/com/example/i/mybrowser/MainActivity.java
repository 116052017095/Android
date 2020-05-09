package com.example.i.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL url=null;
        Intent intent=getIntent();
        Uri uri=intent.getData();

        try {
            url=new URL(uri.getScheme(),uri.getHost(),uri.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }

    browser(url);
    }

    private void browser(URL url) {
        WebView webView=findViewById(R.id.webview);
        webView.loadUrl(url.toString());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
    }
}
