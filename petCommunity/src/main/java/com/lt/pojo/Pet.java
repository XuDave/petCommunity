package com.lt.pojo;

public class Pet {
    private String petid;

    private String petname;

    private String pettypeid;
    
    private String pettypename;

    private String petage;

    private Integer petsex;

    private String userid;

    public String getPetid() {
		return petid;
	}

	public void setPetid(String petid) {
		this.petid = petid;
	}

	public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname == null ? null : petname.trim();
    }

   
    public String getPettypeid() {
		return pettypeid;
	}

	public void setPettypeid(String pettypeid) {
		this.pettypeid = pettypeid;
	}

    public String getPetage() {
		return petage;
	}

	public void setPetage(String petage) {
		this.petage = petage;
	}

	public Integer getPetsex() {
        return petsex;
    }

    public void setPetsex(Integer petsex) {
        this.petsex = petsex;
    }

 
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPettypename() {
		return pettypename;
	}

	public void setPettypename(String pettypename) {
		this.pettypename = pettypename;
	}
    
}