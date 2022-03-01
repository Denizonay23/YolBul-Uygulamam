package com.example.yolbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GirisEkrani extends AppCompatActivity {


    Button ybgec,ogec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);


        Typeface font = Typeface.createFromAsset(getAssets(),"Fonts/planet benson 2.ttf");

        TextView tv = (TextView) findViewById(R.id.tw1);
        tv.setTypeface(font);

        ybgec = (Button)findViewById(R.id.btn_h);
        ogec = (Button)findViewById(R.id.btn_ogs);



        ybgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yb = new Intent(GirisEkrani.this, YolBulmaEkrani.class);
                startActivity(yb);
            }
        });
ogec.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent og = new Intent(GirisEkrani.this, YServis.class);
        startActivity(og);
    }
});
    }

}
