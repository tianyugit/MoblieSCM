package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CustTradedetail {
	
	/** 交易类别 - 手机销售**/
    public static final int TRADETYPE_MOBSALE = 1;

    public static final int TRADETYPE_MOBRETURN = 2;
    
    private String invoiceid;

    private String supplierid;

    private Integer tradetype;

    private Long amount;

    private String type;

    private BigDecimal unitprice;

    private String inputuserid;

    private String inputdate;

    private String checkuserid;

    private String checkdate;

    private BigDecimal totalmoney;
    
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

    public Integer getTradetype() {
        return tradetype;
    }

    public void setTradetype(Integer tradetype) {
        this.tradetype = tradetype;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
    
    

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustTradedetail [invoiceid=" + invoiceid + ", supplierid="
				+ supplierid + ", tradetype=" + tradetype + ", amount="
				+ amount + ", type=" + type + ", unitprice=" + unitprice
				+ ", inputuserid=" + inputuserid + ", inputdate=" + inputdate
				+ ", checkuserid=" + checkuserid + ", checkdate=" + checkdate
				+ ", totalmoney=" + totalmoney + ", orgid=" + orgid
				+ ", remark=" + remark + "]";
	}
    
    
}