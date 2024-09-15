package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;


import static java.util.Locale.getAvailableLocales;


public class MapActivity extends AppCompatActivity
{
    Button currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        currentLocation = findViewById(R.id.currentLocation);
        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Search for police stations nearby
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=police stations");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

    }
}