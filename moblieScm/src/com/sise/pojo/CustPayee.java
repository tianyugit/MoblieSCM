package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CustPayee {
    private String invoiceid;

    private String custid;

    private Integer cashpayment;

    private String payaccount;

    private BigDecimal incomemoney;

    private Integer calculaterebate;

    private String inputuserid;

    private String inputdate;

    private String checkuserid;

    private String checkdate;

    private Integer status;

    private String orgid;

    private String remark;

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid == null ? null : custid.trim();
    }

    public Integer getCashpayment() {
        return cashpayment;
    }

    public void setCashpayment(Integer cashpayment) {
        this.cashpayment = cashpayment;
    }

    public String getPayaccount() {
        return payaccount;
    }

    public void setPayaccount(String payaccount) {
        this.payaccount = payaccount == null ? null : payaccount.trim();
    }

    public BigDecimal getIncomemoney() {
        return incomemoney;
    }

    public void setIncomemoney(BigDecimal incomemoney) {
        this.incomemoney = incomemoney;
    }

    public Integer getCalculaterebate() {
        return calculaterebate;
    }

    public void setCalculaterebate(Integer calculaterebate) {
        this.calculaterebate = calculaterebate;
    }

    public String getInputuserid() {
        return inputuserid;
    }

    public void setInputuserid(String inputuserid) {
        this.inputuserid = inputuserid == null ? null : inputuserid.trim();
    }

    public String getCheckuserid() {
        return checkuserid;
    }

    public void setCheckuserid(String checkuserid) {
        this.checkuserid = checkuserid == null ? null : checkuserid.trim();
    }

    public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}