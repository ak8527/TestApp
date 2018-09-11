package com.example.ashu.workmanagertest;


public class Storage {
    private String fileName , filePath;

    public Storage(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}
