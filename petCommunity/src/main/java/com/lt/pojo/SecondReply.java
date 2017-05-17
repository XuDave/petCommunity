package com.lt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SecondReply {
    private Integer secondreplyid;

    private String secondreplycontent;

    private Integer firstreplyid;

    private Integer userid;

    private Integer pointeruserid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date secondreplyupdatetime;

    public Integer getSecondreplyid() {
        return secondreplyid;
    }

    public void setSecondreplyid(Integer secondreplyid) {
        this.secondreplyid = secondreplyid;
    }

    public String getSecondreplycontent() {
        return secondreplycontent;
    }

    public void setSecondreplycontent(String secondreplycontent) {
        this.secondreplycontent = secondreplycontent == null ? null : secondreplycontent.trim();
    }

    public Integer getFirstreplyid() {
        return firstreplyid;
    }

    public void setFirstreplyid(Integer firstreplyid) {
        this.firstreplyid = firstreplyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPointeruserid() {
        return pointeruserid;
    }

    public void setPointeruserid(Integer pointeruserid) {
        this.pointeruserid = pointeruserid;
    }

    public Date getSecondreplyupdatetime() {
        return secondreplyupdatetime;
    }

    public void setSecondreplyupdatetime(Date secondreplyupdatetime) {
        this.secondreplyupdatetime = secondreplyupdatetime;
    }
}