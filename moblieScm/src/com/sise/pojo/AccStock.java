package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AccStock {
    private String sn;

    private String brand;

    private String accessorytypeid;

    private String fristsupplierid;

    private String firstintime;

    private String lastsupplierid;

    private String lastintime;

    private BigDecimal buyprice;

    private BigDecimal cost;

    private BigDecimal lossamount;

    private String orgid;

    private Integer status;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getAccessorytypeid() {
        return accessorytypeid;
    }

    public void setAccessorytypeid(String accessorytypeid) {
        this.accessorytypeid = accessorytypeid == null ? null : accessorytypeid.trim();
    }

    public String getFristsupplierid() {
        return fristsupplierid;
    }

    public void setFristsupplierid(String fristsupplierid) {
        this.fristsupplierid = fristsupplierid == null ? null : fristsupplierid.trim();
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

	public String getLastsupplierid() {
        return lastsupplierid;
    }

    public void setLastsupplierid(String lastsupplierid) {
        this.lastsupplierid = lastsupplierid == null ? null : lastsupplierid.trim();
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

	@Override
	public String toString() {
		return "Accstock [sn=" + sn + ", brand=" + brand + ", accessorytypeid="
				+ accessorytypeid + ", fristsupplierid=" + fristsupplierid
				+ ", firstintime=" + firstintime + ", lastsupplierid="
				+ lastsupplierid + ", lastintime=" + lastintime + ", buyprice="
				+ buyprice + ", cost=" + cost + ", lossamount=" + lossamount
				+ ", orgid=" + orgid + ", status=" + status + "]";
	}
}