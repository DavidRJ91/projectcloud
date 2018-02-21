package com.iesemilidarder.projectcloud.core.dao;

import com.iesemilidarder.projectcloud.core.base.DBObject;

public class ReviewItem extends DBObject {
    private int id;
    private String name;
    private String location;

    /*Creamos los set y get */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected void beforeSave() {
        doLog("todo!");
    }
}