package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button login,register;
    float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //animation
        login=(Button)findViewById(R.id.button2);
        register=(Button)findViewById(R.id.button1);
        login.setTranslationY(300);
        register.setTranslationY(300);
        login.setAlpha(v);
        register.setAlpha(v);
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        register.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}