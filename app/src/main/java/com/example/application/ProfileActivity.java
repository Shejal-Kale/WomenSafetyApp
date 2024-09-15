package com.example.application;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity
{
    private TextView userName,phoneNo,email;
    private FirebaseUser firebaseUser;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userName = findViewById(R.id.username);
        email=findViewById(R.id.email);
        phoneNo=findViewById(R.id.no);
        b=findViewById(R.id.button4);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users").child(firebaseUser.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                email.setText(snapshot.child("email").getValue().toString());
                userName.setText(snapshot.child("username").getValue().toString());
                phoneNo.setText(snapshot.child("phoneNo").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(ProfileActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                Toast.makeText(ProfileActivity.this, "Log Out Successfully!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }


}