package com.example.yolbul;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class YServis extends AppCompatActivity {
    Button btnServis,geri;
Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yservis);
        geri = (Button)findViewById(R.id.GeriDön);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(YServis.this, GirisEkrani.class);
                startActivity(ob);
            }
        });
btnServis = (Button)findViewById(R.id.btnServis);
    }
    public boolean ServisCalisiyorMu(){
        ActivityManager servisYöneticisi = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo servis: servisYöneticisi.getRunningServices(Integer.MAX_VALUE)){
            if(context.getPackageName().equals(servis.service.getPackageName())){
                return true;
            }
        }
        return false;
    }
    public  void  btnServis_Click(View v){
Button button = (Button) v;
        if (ServisCalisiyorMu()){
            stopService(new Intent(context,Servis.class));
            ((Button) v).setText(getString(R.string.btnBaslat));
        }else{

            startService(new Intent(context,Servis.class));
            ((Button) v).setText(getString(R.string.btnDurdur));
        }
    }
}
