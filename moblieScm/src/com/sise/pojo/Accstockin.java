package com.sise.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Accstockin implements Serializable{

	private static final long serialVersionUID = 8234691600804955040L;
	/** ÉóºË×´Ì¬ - Î´Éó **/
    public static final int STAT_NOTCHECK = 0;
    /** ÉóºË×´Ì¬ - ÒÑÉó **/
    public static final int STAT_CHECKED = 1;
    
    private String invoiceid;

    private String supplierid;

    private String accessorytypeid;

    private String brand;

    private BigDecimal buyprice;

    private Long amount;

    private BigDecimal totalmoney;

    private String inputuserid;

    private String inputdate;

    private String checkuserid;

    private String checkdate;

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

    public String getAccessorytypeid() {
        return accessorytypeid;
    }

    public void setAccessorytypeid(String accessorytypeid) {
        this.accessorytypeid = accessorytypeid == null ? null : accessorytypeid.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Accstockin [invoiceid=" + invoiceid + ", supplierid="
				+ supplierid + ", accessorytypeid=" + accessorytypeid
				+ ", brand=" + brand + ", buyprice=" + buyprice + ", amount="
				+ amount + ", totalmoney=" + totalmoney + ", inputuserid="
				+ inputuserid + ", inputdate=" + inputdate + ", checkuserid="
				+ checkuserid + ", checkdate=" + checkdate + ", status="
				+ status + ", remark=" + remark + "]";
	}
    
    
}