package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TipsActivity extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        rcv=(RecyclerView)findViewById(R.id.rclview);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        int data[]=new int[]{
                R.drawable.tip1,R.drawable.tip2,R.drawable.tip3,R.drawable.tip4,R.drawable.tip5,R.drawable.tip6,R.drawable.tip7};
        rcv.setAdapter(new TipsAdapter(data));
    }
}