package com.nanokylin.catpawserver.common.entity;

public class User {
    private int uid;
    private String username;
    private String password;
    private String privateKey;
    private String publicKey;
    private String createTime;

    public User(int uid,String username,String password,String privateKey,String publicKey,String createTime){
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.createTime = createTime;
    }

    ///////////////////////////Setter and Getter//////////////////////////
    public User setUid(int uid){
        this.uid = uid;
        return this;
    }
    public User setUsername(String username){
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setPrivateKey(String privateKey){
        this.privateKey = privateKey;
        return this;
    }

    public User setPublicKey(String publicKey){
        this.publicKey = publicKey;
        return this;
    }

    public User setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }
    public String getCreateTime(){
        return createTime;
    }
    //////////////////////////////////////////////////////////////////////
}
