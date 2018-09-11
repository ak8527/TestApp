package com.example.ashu.githubprofile;

public class Items {

    String mName,mProfileUrl,mImageUrl,mbioUrl;

    public Items(String mName, String mProfileUrl, String mImageUrl,String mbioUrl) {
        this.mName = mName;
        this.mProfileUrl = mProfileUrl;
        this.mImageUrl = mImageUrl;
        this.mbioUrl = mbioUrl;


    }

    public String getmName() {
        return mName;
    }

    public String getmProfileUrl() {
        return mProfileUrl;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmbioUrl() {
        return mbioUrl;
    }
}
