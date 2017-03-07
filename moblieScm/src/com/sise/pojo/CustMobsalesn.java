package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CustMobsalesn {
    private String sn1;

    private String sn2;

    private String invoiceid;

    private String mobtypeid;

    private String color;

    private String config;

    private String fristsupplierid;

    private String firstintime;

    private String lastsupplierid;

    private String lastintime;

    private BigDecimal buyprice;

    private BigDecimal cost;

    private BigDecimal lossamount;

    private String orgid;

    private Integer status;

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1 == null ? null : sn1.trim();
    }

    public String getSn2() {
        return sn2;
    }

    public void setSn2(String sn2) {
        this.sn2 = sn2 == null ? null : sn2.trim();
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid == null ? null : mobtypeid.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config == null ? null : config.trim();
    }

    public String getFristsupplierid() {
        return fristsupplierid;
    }

    public void setFristsupplierid(String fristsupplierid) {
        this.fristsupplierid = fristsupplierid == null ? null : fristsupplierid.trim();
    }

    public String getLastsupplierid() {
        return lastsupplierid;
    }

    public void setLastsupplierid(String lastsupplierid) {
        this.lastsupplierid = lastsupplierid == null ? null : lastsupplierid.trim();
    }

    public String getFirstintime() {
		return firstintime;
	}

	public void setFirstintime(String firstintime) {
		this.firstintime = firstintime;
	}

	public String getLastintime() {
		return lastintime;
	}

	public void setLastintime(String lastintime) {
		this.lastintime = lastintime;
	}

	public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getLossamount() {
        return lossamount;
    }

    public void setLossamount(BigDecimal lossamount) {
        this.lossamount = lossamount;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}