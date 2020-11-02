package com.nanokylin.catpawserver.database.entity;

public class User {
    private int UID;
    private String email;
    private String username;
    private String password;
    private String createTime;
    private String updateTime;

    public User(int UID,String email,String username,String password,String createTime,String updateTime){
        this.UID =UID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.updateTime =updateTime;
    }

    ///////////////////////////Setter and Getter//////////////////////////


    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUID() {
        return UID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }
    //////////////////////////////////////////////////////////////////////
}
