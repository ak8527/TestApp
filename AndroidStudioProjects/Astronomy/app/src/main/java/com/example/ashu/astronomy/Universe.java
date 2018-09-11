package com.example.ashu.astronomy;

import android.os.Parcel;
import android.os.Parcelable;

public class Universe implements Parcelable {

    String mName,mContent,mImageUrl;

    public Universe(String mName, String mContent, String mImageUrl) {
        this.mName = mName;
        this.mContent = mContent;
        this.mImageUrl = mImageUrl;
    }

    protected Universe(Parcel in) {
        mName = in.readString();
        mContent = in.readString();
        mImageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mContent);
        dest.writeString(mImageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Universe> CREATOR = new Creator<Universe>() {
        @Override
        public Universe createFromParcel(Parcel in) {
            return new Universe(in);
        }

        @Override
        public Universe[] newArray(int size) {
            return new Universe[size];
        }
    };

    public String getmName() {
        return mName;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }


}
