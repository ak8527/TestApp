package com.example.ashu.customadapter;

public class studentInfo {

    String name,batch,location;


    public studentInfo(String name, String batch, String location) {
        this.name = name;
        this.batch = batch;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
