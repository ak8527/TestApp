package com.example.ashu.notes;

public class NotesInfo {
    String mTitle,mContent,mDate;

    public NotesInfo(String mTitle, String mContent, String mDate) {
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
