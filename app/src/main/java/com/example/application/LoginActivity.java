package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LoginActivity extends AppCompatActivity
{
    TextView alreadyAccount,forgetPass;
    //FloatingActionButton google,fb;
    EditText email,pass;
    Button b;
    ProgressDialog bar;
    FirebaseAuth auth;
    CheckBox remeberMe;
    float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        alreadyAccount=findViewById(R.id.textView4);
        forgetPass=findViewById(R.id.textView5);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.editTextTextPassword);
        b=findViewById(R.id.button);
        bar=new ProgressDialog(this);
        auth=FirebaseAuth.getInstance();
        remeberMe=findViewById(R.id.checkBox);
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkBox=preferences.getString("remember","");
        if(checkBox.equals("true"))
        {
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();

        }
        else if(checkBox.equals(false))
        {
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show();

        }
        //animation
        email.setTranslationY(300);
        pass.setTranslationY(300);
        forgetPass.setTranslationY(300);
        alreadyAccount.setTranslationY(300);
        b.setTranslationY(300);
        remeberMe.setTranslationY(300);
      ;

        b.setAlpha(v);
        alreadyAccount.setAlpha(v);
        email.setAlpha(v);
        pass.setAlpha(v);
        forgetPass.setAlpha(v);
        remeberMe.setAlpha(v);

        b.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        alreadyAccount.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        forgetPass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        remeberMe.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
       // google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        alreadyAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String emailAdd=email.getText().toString();
                String password=pass.getText().toString();
                if(emailAdd.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"All Fields Required!!",Toast.LENGTH_LONG).show();
                }
                else {
                    loginAttempt(emailAdd,password);
                }
            }
        });
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail=new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog=new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Enter your email to reset the password: ");
                passwordResetDialog.setView(resetMail);
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String mail=resetMail.getText().toString();
                        auth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this,"Reset link sent to your Email",Toast.LENGTH_LONG).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this,"Failed to send reset link "+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //closes dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });
        remeberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(remeberMe.isChecked())
                {
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                }else if(!remeberMe.isChecked())
                {
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                }
            }
        });

    }
    private void loginAttempt(String email,String password)
    {
        bar.show();
        bar.setTitle("Login");
        bar.setMessage("Please Wait...");
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                bar.dismiss();
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this,"Login Successfully!!",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}