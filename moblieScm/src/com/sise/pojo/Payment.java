package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
	
	/** ÉóºË×´Ì¬ - Î´Éó **/
    public static final int STAT_NOTCHECK = 0;
    /** ÉóºË×´Ì¬ - ÒÑÉó **/
    public static final int STAT_CHECKED = 1;
    
    private String invoiceid;

    private String supplierid;

    private Integer cashpayment;

    private String accountid;

    private BigDecimal paymoney;

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

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    public Integer getCashpayment() {
        return cashpayment;
    }

    public void setCashpayment(Integer cashpayment) {
        this.cashpayment = cashpayment;
    }

    public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
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

	@Override
	public String toString() {
		return "Payment [invoiceid=" + invoiceid + ", supplierid=" + supplierid
				+ ", cashpayment=" + cashpayment + ", payaccount=" + accountid
				+ ", paymoney=" + paymoney + ", calculaterebate="
				+ calculaterebate + ", inputuserid=" + inputuserid
				+ ", inputdate=" + inputdate + ", checkuserid=" + checkuserid
				+ ", checkdate=" + checkdate + ", status=" + status
				+ ", orgid=" + orgid + ", remark=" + remark + "]";
	}
    
    
}