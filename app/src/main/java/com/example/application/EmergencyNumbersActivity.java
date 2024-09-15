package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Bundle;

public class EmergencyNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_numbers);
        RecyclerView recyclerView=findViewById(R.id.recyleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EmergencyNumbersData[] data=new EmergencyNumbersData[]
                {
                    new EmergencyNumbersData("Call Ambulance","102",R.drawable.ambulance1),
                        new EmergencyNumbersData("Women Helpline","1091",R.drawable.girl),
                        new EmergencyNumbersData("NCW","011-26942369",R.drawable.icon3),
                        new EmergencyNumbersData("Emergency Helpline","112",R.drawable.helpline_icon),
                };
        EmergencyNumbersAdapter adapter=new EmergencyNumbersAdapter(data,EmergencyNumbersActivity.this);
        recyclerView.setAdapter(adapter);
    }

}