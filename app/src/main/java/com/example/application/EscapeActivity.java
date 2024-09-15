package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class EscapeActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape);
        rcv=(RecyclerView)findViewById(R.id.rclview);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        int data[]=new int[]
                {
                R.drawable.esc1,R.drawable.esc2,R.drawable.esc4,R.drawable.esc5,R.drawable.esc6};
        rcv.setAdapter(new escapeAdapter(data));
    }
}