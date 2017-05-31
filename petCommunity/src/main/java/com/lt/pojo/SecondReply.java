package com.lt.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SecondReply {
    private String secondreplyid;

    private String secondreplycontent;

    private String firstreplyid;

    private String userid;

    private String pointeruserid;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date secondreplyupdatetime;
   
    

    public String getSecondreplyid() {
		return secondreplyid;
	}

	public void setSecondreplyid(String secondreplyid) {
		this.secondreplyid = secondreplyid;
	}

	public String getSecondreplycontent() {
        return secondreplycontent;
    }

    public void setSecondreplycontent(String secondreplycontent) {
        this.secondreplycontent = secondreplycontent == null ? null : secondreplycontent.trim();
    }

    public String getFirstreplyid() {
		return firstreplyid;
	}

	public void setFirstreplyid(String firstreplyid) {
		this.firstreplyid = firstreplyid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPointeruserid() {
		return pointeruserid;
	}

	public void setPointeruserid(String pointeruserid) {
		this.pointeruserid = pointeruserid;
	}

	public Date getSecondreplyupdatetime() {
        return secondreplyupdatetime;
    }

    public void setSecondreplyupdatetime(Date secondreplyupdatetime) {
        this.secondreplyupdatetime = secondreplyupdatetime;
    }
}