package com.example.yolbul;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class YolBulmaEkrani extends FragmentActivity implements OnMapReadyCallback {
Button geri;
private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yol_bulma_ekrani);
        Typeface font = Typeface.createFromAsset(getAssets(),"Fonts/planet benson 2.ttf");
        TextView tv = (TextView) findViewById(R.id.YolBulResim);
        tv.setTypeface(font);
        geri = (Button)findViewById(R.id.button);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(YolBulmaEkrani.this,GirisEkrani.class);
                startActivity(g);
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setTrafficEnabled(true);
        LatLng atasehir = new LatLng(40.9833483,29.1190232);
        mMap.addMarker(new MarkerOptions().position(atasehir).title("atasehir"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(atasehir,12));
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        mMap.setMyLocationEnabled(true);
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
mMap.setOnMyLocationChangeListener(new LocationGozlemci());
    }
    public class LocationGozlemci implements GoogleMap.OnMyLocationChangeListener{
        @Override
        public void onMyLocationChange(Location location) {
            LatLng loc = new LatLng(location.getLatitude(),location.getLongitude());
            Projection p = mMap.getProjection();
            Point point = p.toScreenLocation(loc);
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(loc);
            circleOptions.fillColor(Color.RED);
            circleOptions.radius(10);
            circleOptions.strokeWidth(1);
            mMap.addCircle(circleOptions);
        }
    }

}




