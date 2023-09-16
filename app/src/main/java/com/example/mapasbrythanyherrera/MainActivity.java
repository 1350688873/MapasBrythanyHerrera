package com.example.mapasbrythanyherrera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText lat, longt;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lat= findViewById(R.id.latitud);
        longt= findViewById(R.id.longitud);
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        lat.setText(""+latLng.latitude);
        longt.setText(""+latLng.longitude);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        lat.setText(""+latLng.latitude);
        longt.setText(""+latLng.longitude);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng ecuador = new LatLng(-1.0127455,-79.4701186);
        mMap.addMarker(new MarkerOptions().position(ecuador).title("UNIVESIDAD TECNICA ESTATAL DE QUEVEDO"));
        mMap.moveCamera((CameraUpdateFactory.newLatLng(ecuador)));
    }
}