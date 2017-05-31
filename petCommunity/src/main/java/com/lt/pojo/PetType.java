package com.lt.pojo;

public class PetType {
    private String pettypeid;

    private String pettypecontent;

    private String pettypename;

    public String getPettypeid() {
		return pettypeid;
	}

	public void setPettypeid(String pettypeid) {
		this.pettypeid = pettypeid;
	}

	public String getPettypecontent() {
        return pettypecontent;
    }

    public void setPettypecontent(String pettypecontent) {
        this.pettypecontent = pettypecontent == null ? null : pettypecontent.trim();
    }

    public String getPettypename() {
        return pettypename;
    }

    public void setPettypename(String pettypename) {
        this.pettypename = pettypename == null ? null : pettypename.trim();
    }
}