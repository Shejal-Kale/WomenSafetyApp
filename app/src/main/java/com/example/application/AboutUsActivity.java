package com.example.application;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import static android.graphics.Color.BLACK;

public class AboutUsActivity extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        t=findViewById(R.id.about);
        t.setTextSize(20);
        t.setTextColor(BLACK);
        t.setText("      Women’s safety is a big concern which has been the most important topic till date. Women safety matters a lot whether at home, outside the home or working place. Few crimes against ladies particularly rape cases were terribly dread and fearful. Most of the women of various ages, till this day are being subjected to violence, domestic abuse, and rape. As ladies ought to travel late night generally, it’s necessary to remain alert and safe.\n"
                +"       Although the government is taking necessary measures for their safety, still, there are free safety apps for women that can help them to stay safe. Most of the females these days carry their smartphone with them, so it is necessary to have at least one the personal safety apps installed. Such a security app for ladies will definitely facilitate in a way or the opposite.\n" +
                "        This is user-friendly application that can be accessed by anyone who has installed it in their smart phones.\n" +
                "        Our intention is to provide you with fastest and simplest way to contact your nearest help.In this system user needs to feed contact numbers of their friends or family members, in case of emergency on shaking the phone, the system sends SMS to your added friends or family members with your current location.\n" +
                "        Also for caution, you can also send message to particular person, so he/she can contact you immediately. This features for both everyday safety and real emergencies, making it an ultimate tool for all.\n" +
                "\nFor any query please contact us at:\n\n"+"Email-id: HerSafey@gmail.com\n"+"Phone Number: 1234567890\n\n"+"Thank you for using our application.\n"
               );
    }
}