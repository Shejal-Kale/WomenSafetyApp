package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static android.graphics.Color.BLACK;

public class LawsActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);
        text=findViewById(R.id.law);
        text.setTextSize(25);
        text.setTextColor(BLACK);
        text.setText("\n\nRape (Sections 375, 376, 376A, 3768, 3760, 376D and 376E)\n\n"+
                "Kidnapping and abduction for different purposes (Sections 363-373)\n\n"+
                "Murder, Dowry death, Abetment of Suicide, etc (Sections 302, 3048 and 306)\n\n"+
                "Cruelty by husband or his relatives (Section 498A)\n\n"+
                "Outraging the modesty of women (Section 354)\n\n" +
                "Sexual harassment (Section 354A)\n\n" +
                "Assault on women with intent to disrobe a woman (Section 3545)\n\n" +
                "Voyeurism (Section 3540)\n\n" +
                "Stalking (Section 354D)\n\n" +
                "Word, gesture or act intended to Insult the modesty of a woman (Section 509)\n\n");
    }
}