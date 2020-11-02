package com.nanokylin.catpawserver.database.entity;

public class Key {
    private int UID;
    private String publicKey;
    private String privateKey;
    private String createTime;
    private String updateTime;

    public Key(int UID,String publicKey,String privateKey,String createTime,String updateTime){
        this.UID = UID;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    ///////////////////////////Setter and Getter//////////////////////////


    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
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

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }
    //////////////////////////////////////////////////////////////////////
}
