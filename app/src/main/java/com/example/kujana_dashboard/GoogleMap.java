package com.example.kujana_dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    com.google.android.gms.maps.GoogleMap map;
    Button btnDestination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnDestination = (Button)findViewById(R.id.btnDestination);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.tracking);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),
                                UserProfile.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tracking:
                        return true;
                }
                return false;
            }
        });


        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoogleMap.this, Tracking.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {

        map = googleMap;

        LatLng Melbourne = new LatLng(-37.775276, 145.224203);
        map.addMarker(new MarkerOptions().position(Melbourne).title("Melbourne"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Melbourne));
    }
}
