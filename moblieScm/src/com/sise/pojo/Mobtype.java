package com.sise.pojo;

import java.util.Arrays;
import java.util.List;

public class Mobtype {
    private String mobtypeid;

    private String brand;

    private String mobtypename;

    private Float buyprice;

    private String remark;
    
    private String[] bonusList;

    public String[] getBonusList() {
		return bonusList;
	}

	public void setBonusList(String[] bonusList) {
		this.bonusList = bonusList;
	}
	
    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid == null ? null : mobtypeid.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getMobtypename() {
        return mobtypename;
    }

    public void setMobtypename(String mobtypename) {
        this.mobtypename = mobtypename == null ? null : mobtypename.trim();
    }

	public Float getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(Float buyprice) {
		this.buyprice = buyprice;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	

	@Override
	public String toString() {
		return "Mobtype [mobtypeid=" + mobtypeid + ", brand=" + brand
				+ ", mobtypename=" + mobtypename + ", buyprice=" + buyprice
				+ ", remark=" + remark + ", bonusList="
				+ Arrays.toString(bonusList) + "]";
	}
    
}