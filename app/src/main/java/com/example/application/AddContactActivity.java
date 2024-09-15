package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Objects;

public class AddContactActivity extends AppCompatActivity
{
    EditText name,number;
    Button b;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name=findViewById(R.id.contactName);
        number=findViewById(R.id.contactNo);
        b=findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String cName=name.getText().toString();
                String no=number.getText().toString();
                if(!cName.isEmpty() && !no.isEmpty())
                {
                    addContacts(cName,no);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Contact is invalid!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void addContacts(String name,String number)
    {
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Contacts").child(user.getUid());
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("ContactName",name);
        hashMap.put("ContactNo",number);
        databaseReference.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}