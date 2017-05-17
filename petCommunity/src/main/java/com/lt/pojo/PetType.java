package com.lt.pojo;

public class PetType {
    private Integer pettypeid;

    private String pettypecontent;

    private String pettypename;

    public Integer getPettypeid() {
        return pettypeid;
    }

    public void setPettypeid(Integer pettypeid) {
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