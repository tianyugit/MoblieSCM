package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CustMobsale {
    private String invoiceid;

    private String supplierid;

    private String brand;

    private String mobtypeid;

    private String custid;

    private Long amount;

    private BigDecimal saleprice;
    
    private BigDecimal totalmoney;

    private String inputuserid;

    private String inputdate;

    private String checkdate;

    private String checkuserid;

    private Integer status;

    private String remark;

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid == null ? null : mobtypeid.trim();
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid == null ? null : custid.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public String getInputuserid() {
        return inputuserid;
    }

    public void setInputuserid(String inputuserid) {
        this.inputuserid = inputuserid == null ? null : inputuserid.trim();
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate == null ? null : checkdate.trim();
    }

    public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getCheckuserid() {
		return checkuserid;
	}

	public void setCheckuserid(String checkuserid) {
		this.checkuserid = checkuserid;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	@Override
	public String toString() {
		return "CustMobsale [invoiceid=" + invoiceid + ", supplierid="
				+ supplierid + ", brand=" + brand + ", mobtypeid=" + mobtypeid
				+ ", custid=" + custid + ", amount=" + amount + ", saleprice="
				+ saleprice + ", totalmoney=" + totalmoney + ", inputuserid="
				+ inputuserid + ", inputdate=" + inputdate + ", checkdate="
				+ checkdate + ", checkuserid=" + checkuserid + ", status="
				+ status + ", remark=" + remark + "]";
	}
    
    
}