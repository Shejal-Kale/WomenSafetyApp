package com.example.application;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class UsersData
{
    private String userId;
    private String email;
    private String username;
    private String phoneNo;
    private String imageUrl;
    public UsersData()
    {

    }
    public UsersData(String username,String phoneNo,String userId, String email, String imageURL)
    {
        this.username=username;
        this.phoneNo=phoneNo;
        this.userId=userId;
        this.email=email;
        this.imageUrl=imageURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageURL(String imageURL) {
        this.imageUrl = imageURL;
    }


}
