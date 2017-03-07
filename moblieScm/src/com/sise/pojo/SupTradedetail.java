package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SupTradedetail {
	/** 交易类别 - 手机入库 **/
    public static final int TRADETYPE_MOBSTOCKIN = 1;

    public static final int TRADETYPE_MOBRETURN = 2;
    private String invoiceid;

    private Integer status;

    private String supplierid;

    private Integer tradetype;

    private String type;

    private Integer amount;

    private BigDecimal unitprice;

    private String inputdate;

    private String inputuserid;

    private String checkuserid;

    private String checkdate;

    private BigDecimal totalmoney;

    private String orgid;

    private String remark;

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid == null ? null : supplierid.trim();
    }

    public Integer getTradetype() {
        return tradetype;
    }

    public void setTradetype(Integer tradetype) {
        this.tradetype = tradetype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
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

	public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
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
		return "SupTradedetail [invoiceid=" + invoiceid + ", status=" + status
				+ ", supplierid=" + supplierid + ", tradetype=" + tradetype
				+ ", type=" + type + ", amount=" + amount + ", unitprice="
				+ unitprice + ", inputdate=" + inputdate + ", inputuserid="
				+ inputuserid + ", checkuserid=" + checkuserid + ", checkdate="
				+ checkdate + ", totalmoney=" + totalmoney + ", orgid=" + orgid
				+ ", remark=" + remark + "]";
	}
    
    
}