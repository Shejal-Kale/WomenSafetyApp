package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.media.Image;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ImageView callPolice,emergency,nearBy,message,defence,escape;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setContentView(R.layout.activity_home);
        callPolice=findViewById(R.id.callPolice);
        nearBy=findViewById(R.id.nearBy);
        message=findViewById(R.id.message);
        emergency=findViewById(R.id.emergency);
        defence=findViewById(R.id.defence);
        escape=findViewById(R.id.escape);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toolbar=(Toolbar)findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home:
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_profile:
                        Intent intent1=new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_aboutus:
                        Intent intent2=new Intent(HomeActivity.this,AboutUsActivity.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_rateus:
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+"com.android.chrome")));
                        }
                        catch (ActivityNotFoundException e)
                        {
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;
                    case R.id.menu_tips:Intent intent3=new Intent(HomeActivity.this,TipsActivity.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_laws:
                        Intent intent4=new Intent(HomeActivity.this,LawsActivity.class);
                        startActivity(intent4);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,FriendsActivity.class);
                startActivity(intent);
            }
        });
        nearBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=police stations");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,EmergencyNumbersActivity.class);
                startActivity(intent);

            }
        });
        callPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+100));
                startActivity(callIntent);
            }
        });
        defence.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(HomeActivity.this,DefenceActivity.class);
                startActivity(callIntent);
            }
        });
        escape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(HomeActivity.this,EscapeActivity.class);
                startActivity(callIntent);
            }
        });
    }
}