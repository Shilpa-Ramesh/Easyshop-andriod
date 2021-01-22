package com.example.finaleasyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.Exclude;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Furniture_Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private String mEmail;
    private String mUser;
    private String mPrice;
    private String mDate;
    private String mDesc;
    private String msize;

    public Furniture_Upload() {
    }

    public Furniture_Upload(String name, String imageUrl, String price, String asize,String desc) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        msize= asize;
        mImageUrl = imageUrl;
        mEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        mDesc = desc;
        mUser = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        mPrice = price;
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        mDate = df.format(date);



    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getEmail() { return mEmail; }
    public void setEmail(String email) { mEmail = email; }

    public String getUserName() { return mUser; }
    public void setUserName(String userName) { mUser = userName; }

    public String getDesc() { return mDesc; }
    public void setDesc(String desc) { mDesc = desc; }

    public String getPrice() {return mPrice;}
    public void setPrice(String price) { mPrice = price;}

    public String getasize() {return msize;}
    public void setasize(String asize) { msize =asize;}


    @Exclude
    public String getKey() {
        return mKey;
    }
    @Exclude
    public void setKey(String key) {
        mKey = key;
    }

    public String getDate(){ return mDate; }
    public void setDate(String date) { mDate = date; }
}