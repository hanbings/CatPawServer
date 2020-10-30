package com.nanokylin.catpawserver.common.entity;

public class Picture {
    private String PICID;
    private String username;
    private String isPublic;
    private String createTime;

    public Picture(String PICID,String username,String isPublic,String createTime){
        this.PICID = PICID;
        this.username = username;
        this.isPublic = isPublic;
        this.createTime = createTime;
    }

    ///////////////////////////Setter and Getter//////////////////////////

    public Picture setPICID(String PICID) {
        this.PICID = PICID;
        return this;
    }

    public Picture setUsername(String username) {
        this.username = username;
        return this;
    }

    public Picture setIsPublic(String isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    public Picture setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getPICID() {
        return PICID;
    }

    public String getUsername() {
        return username;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public String getCreateTime() {
        return createTime;
    }
    //////////////////////////////////////////////////////////////////////
}
