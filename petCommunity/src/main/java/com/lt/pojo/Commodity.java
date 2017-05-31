package com.lt.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Commodity {
	private String commodityid;

	private BigDecimal commodityprice;

	private String commoditycontent;

	private Integer commoditycount;

	private String commodityimagepath;

	private Integer commoditystate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date commodityupdatetime;

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public BigDecimal getCommodityprice() {
		return commodityprice;
	}

	public void setCommodityprice(BigDecimal commodityprice) {
		this.commodityprice = commodityprice;
	}

	public String getCommoditycontent() {
		return commoditycontent;
	}

	public void setCommoditycontent(String commoditycontent) {
		this.commoditycontent = commoditycontent == null ? null : commoditycontent.trim();
	}

	
	public String getCommodityimagepath() {
		return commodityimagepath;
	}

	public void setCommodityimagepath(String commodityimagepath) {
		this.commodityimagepath = commodityimagepath;
	}

	public Integer getCommoditycount() {
		return commoditycount;
	}

	public void setCommoditycount(Integer commoditycount) {
		this.commoditycount = commoditycount;
	}

	public Integer getCommoditystate() {
		return commoditystate;
	}

	public void setCommoditystate(Integer commoditystate) {
		this.commoditystate = commoditystate;
	}

	public Date getCommodityupdatetime() {
		return commodityupdatetime;
	}

	public void setCommodityupdatetime(Date commodityupdatetime) {
		this.commodityupdatetime = commodityupdatetime;
	}
}