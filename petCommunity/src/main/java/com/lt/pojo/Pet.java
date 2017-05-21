package com.lt.pojo;

public class Pet {
    private Integer petid;

    private String petname;

    private Integer pettypeid;
    
    private String pettypename;

    private Integer petage;

    private Integer petsex;

    private Integer userid;

    public Integer getPetid() {
        return petid;
    }

    public void setPetid(Integer petid) {
        this.petid = petid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname == null ? null : petname.trim();
    }

    public Integer getPettypeid() {
        return pettypeid;
    }

    public void setPettypeid(Integer pettypeid) {
        this.pettypeid = pettypeid;
    }

    public Integer getPetage() {
        return petage;
    }

    public void setPetage(Integer petage) {
        this.petage = petage;
    }

    public Integer getPetsex() {
        return petsex;
    }

    public void setPetsex(Integer petsex) {
        this.petsex = petsex;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

	public String getPettypename() {
		return pettypename;
	}

	public void setPettypename(String pettypename) {
		this.pettypename = pettypename;
	}
    
}