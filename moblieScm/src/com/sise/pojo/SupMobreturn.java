package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SupMobreturn {
    private String invoiceid;

    private String supplierid;

    private String mobtypeid;

    private Long amount;

    private BigDecimal returnprice;

    private Double money;

    private String inputuserid;

    private String inputdate;

    private String checkuserid;

    private String checkdate;

    private String remark;

    private Integer status;

    private String orgid;

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

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid == null ? null : mobtypeid.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getReturnprice() {
        return returnprice;
    }

    public void setReturnprice(BigDecimal returnprice) {
        this.returnprice = returnprice;
    }



    public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
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

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

	@Override
	public String toString() {
		return "SupMobreturn [invoiceid=" + invoiceid + ", supplierid="
				+ supplierid + ", mobtypeid=" + mobtypeid + ", amount="
				+ amount + ", returnprice=" + returnprice + ", money=" + money
				+ ", inputuserid=" + inputuserid + ", inputdate=" + inputdate
				+ ", checkuserid=" + checkuserid + ", checkdate=" + checkdate
				+ ", remark=" + remark + ", status=" + status + ", orgid="
				+ orgid + "]";
	}
    
    
}