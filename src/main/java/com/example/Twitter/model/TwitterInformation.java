package com.example.Twitter.model;

import java.util.Date;

public class TwitterInformation {
    String txt;
    long id;
    Date createdAt;
    String profileImageUrl;
    String name;
    String screenName;
    public TwitterInformation() {
    }

    public TwitterInformation(String txt, long id, Date createdAt, String profileImageUrl, String name, String screenName) {
        this.txt = txt;
        this.id = id;
        this.createdAt = createdAt;
        this.profileImageUrl = profileImageUrl;
        this.name = name;
        this.screenName = screenName;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public String toString() {
        return "TwitterInformation{" +
                "txt='" + txt + '\'' +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                '}';
    }
}
