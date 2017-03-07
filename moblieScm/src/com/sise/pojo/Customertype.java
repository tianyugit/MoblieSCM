package com.sise.pojo;

import java.math.BigDecimal;

public class Customertype {
    private String custtypeid;
    
    private BigDecimal discount;

    private String custtypename;

    private String remark;

    public String getCusttypeid() {
        return custtypeid;
    }

    public void setCusttypeid(String custtypeid) {
        this.custtypeid = custtypeid == null ? null : custtypeid.trim();
    }

    public String getCusttypename() {
        return custtypename;
    }

    public void setCusttypename(String custtypename) {
        this.custtypename = custtypename == null ? null : custtypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Customertype [custtypeid=" + custtypeid + ", discount="
				+ discount + ", custtypename=" + custtypename + ", remark="
				+ remark + "]";
	}
    
}