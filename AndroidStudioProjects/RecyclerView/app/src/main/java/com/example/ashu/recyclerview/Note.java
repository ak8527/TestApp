package com.example.ashu.recyclerview;

public class Note {
    String mTitle,mContent,mDate;

    public Note(String mTitle, String mContent, String mDate) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmDate() {
        return mDate;
    }
}
