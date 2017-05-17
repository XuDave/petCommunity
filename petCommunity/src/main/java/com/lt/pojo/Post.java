package com.lt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Post {
    private Integer postid;

    private Integer userid;

    private String posttitle;

    private String postcontent;

    private String postimagepath;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date postupdatetime;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle == null ? null : posttitle.trim();
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent == null ? null : postcontent.trim();
    }

    public String getPostimagepath() {
        return postimagepath;
    }

    public void setPostimagepath(String postimagepath) {
        this.postimagepath = postimagepath == null ? null : postimagepath.trim();
    }

    public Date getPostupdatetime() {
        return postupdatetime;
    }

    public void setPostupdatetime(Date postupdatetime) {
        this.postupdatetime = postupdatetime;
    }
}