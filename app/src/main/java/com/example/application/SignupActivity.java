package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity
{
    TextView oldUser;
    EditText email,pass1,pass2,username,no;
    Button b;
    FirebaseAuth auth;
    ProgressDialog bar;
    DatabaseReference databaseReference;
    float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=findViewById(R.id.username);
        no=findViewById(R.id.Phone);
        email=findViewById(R.id.email1);
        pass1=findViewById(R.id.Password1);
        pass2=findViewById(R.id.Password2);
        oldUser=findViewById(R.id.textView3);
        b=findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();
        bar=new ProgressDialog(this);

        //animation
        username.setTranslationY(300);
        no.setTranslationY(300);
        email.setTranslationY(300);
        pass1.setTranslationY(300);
        pass2.setTranslationY(300);
        oldUser.setTranslationY(300);
        b.setTranslationY(300);

        username.setAlpha(v);
        no.setAlpha(v);
        email.setAlpha(v);
        pass1.setAlpha(v);
        pass2.setAlpha(v);
        oldUser.setAlpha(v);
        b.setAlpha(v);

        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        no.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass2.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        oldUser.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        b.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();


        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String userName=username.getText().toString();
                String phoneNo=no.getText().toString();
                String emailAdd=email.getText().toString();
                String password=pass1.getText().toString();
                String confirmPassword=pass2.getText().toString();
                //Validation
                if(!userName.isEmpty())
                {
                        if(!emailAdd.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailAdd).matches())
                        {
                            if (!password.isEmpty())
                            {
                                if (confirmPassword.equals(password))
                                {
                                    attemptRegistration(userName,phoneNo,emailAdd, password);
                                }
                                else{
                                    pass2.setError("Password doesn't match!!");
                                }
                            }
                            else {
                                pass1.setError("Password is invalid!!");
                            }
                        }
                        else{
                            email.setError("Email is invalid");
                        }
                    } else
                {
                    username.setError("Username is invalid!!");
                }

            }
        });
        oldUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void attemptRegistration(String username, String phoneNo,String emailAdd,String password)
    {
        bar.show();
        bar.setTitle("Registration");
        bar.setMessage("Please Wait...");

        auth.createUserWithEmailAndPassword(emailAdd,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user=auth.getCurrentUser();
                    /*
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid)
                        {
                            Toast.makeText(SignupActivity.this, "Verification Email has been Sent..",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(SignupActivity.this, "Failed to send verification Email"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });*/

                    assert user!=null;
                    String userId=user.getUid();
                    databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    HashMap<String,String> hashMap=new HashMap<>();
                    hashMap.put("userId",userId);
                    hashMap.put("username",username);
                    hashMap.put("phoneNo",phoneNo);
                    hashMap.put("email",emailAdd);
                    hashMap.put("imageUrl","default");
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            bar.dismiss();
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignupActivity.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else
                {
                    bar.dismiss();
                    Toast.makeText(SignupActivity.this,Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                    //Toast.makeText(SignupActivity.this,Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}