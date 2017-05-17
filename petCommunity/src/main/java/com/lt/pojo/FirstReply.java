package com.lt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FirstReply {
    private Integer firstreplyid;

    private String firstreplycontent;

    private Integer userid;

    private Integer postid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date firstreplyupdatetime;

    public Integer getFirstreplyid() {
        return firstreplyid;
    }

    public void setFirstreplyid(Integer firstreplyid) {
        this.firstreplyid = firstreplyid;
    }

    public String getFirstreplycontent() {
        return firstreplycontent;
    }

    public void setFirstreplycontent(String firstreplycontent) {
        this.firstreplycontent = firstreplycontent == null ? null : firstreplycontent.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Date getFirstreplyupdatetime() {
        return firstreplyupdatetime;
    }

    public void setFirstreplyupdatetime(Date firstreplyupdatetime) {
        this.firstreplyupdatetime = firstreplyupdatetime;
    }
}