package com.example.yolbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Baslangic extends AppCompatActivity {
    private static int SPLASH_SURESI = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baslangic);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Baslangic.this,PasswordEkrani.class);
                startActivity(intent);
            }
        },SPLASH_SURESI);
    }
}
