package com.iesinfantaelena.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onBackPressed(){
        WebView pagina=findViewById(R.id.pagina);
        if (pagina.canGoBack())pagina.goBack();
        else super.finish();
    }
}