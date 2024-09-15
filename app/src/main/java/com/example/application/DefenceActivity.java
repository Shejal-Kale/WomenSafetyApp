package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DefenceActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defence);
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        defenceData[] data=new defenceData[]{
                new defenceData(R.drawable.def,"Bear hug"),
                new defenceData(R.drawable.defence2,"Arm Pull"),
                new defenceData(R.drawable.defence3,"Hair pull"),
                new defenceData(R.drawable.defence4,"Wall choke"),
                new defenceData(R.drawable.defence5,"One arm choke"),
                new defenceData(R.drawable.defence6,"One arm choke"),
                new defenceData(R.drawable.defence7,"Ground choke"),
                new defenceData(R.drawable.defence8,"Pipe or danda attack"),
        };
        defenceAdapter adapter=new defenceAdapter(data,this);
        recyclerView.setAdapter(adapter);
    }
}