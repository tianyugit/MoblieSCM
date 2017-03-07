package com.sise.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Mobstockin {

    /** …Û∫À◊¥Ã¨ - Œ¥…Û **/
    public static final int STAT_NOTCHECK = 0;
    /** …Û∫À◊¥Ã¨ - “—…Û **/
    public static final int STAT_CHECKED = 1;

    private String invoiceid;

    private String supTypeId;
    private String supplierid;
    private String supName;

    private String brand;
    private String mobtypeid;
    private String mobTypeName;

    private String color;

    private String config;

    private BigDecimal buyprice;

    private Long amount;

    private Double totalmoney;

    private String inputdate;

    private String inputuserid;
    private String inputUserName;

    private String checkdated;

    private String checkuserid;
    private String checkUserName;

    private Integer status;
    private String statName;

    private String remark;

    private String orgid;
    private String orgName;
    
   

	public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getMobTypeName() {
        return mobTypeName;
    }

    public void setMobTypeName(String mobTypeName) {
        this.mobTypeName = mobTypeName;
    }

    public String getInputUserName() {
        return inputUserName;
    }

    public void setInputUserName(String inputUserName) {
        this.inputUserName = inputUserName;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
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

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

   

    public String getInputuserid() {
        return inputuserid;
    }

    public void setInputuserid(String inputuserid) {
        this.inputuserid = inputuserid;
    }

    

    public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getCheckdated() {
		return checkdated;
	}

	public void setCheckdated(String checkdated) {
		this.checkdated = checkdated;
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
        if (status != null) {
            if (status == STAT_CHECKED) {
                this.statName = "“—…Û∫À";
            } else if (status == STAT_NOTCHECK) {
                this.statName = "Œ¥…Û∫À";
            }
        }
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSupTypeId() {
        return supTypeId;
    }

    public void setSupTypeId(String supTypeId) {
        this.supTypeId = supTypeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

	@Override
	public String toString() {
		return "Mobstockin [invoiceid=" + invoiceid + ", supTypeId="
				+ supTypeId + ", supplierid=" + supplierid + ", supName="
				+ supName + ", brand=" + brand + ", mobtypeid=" + mobtypeid
				+ ", mobTypeName=" + mobTypeName + ", color=" + color
				+ ", config=" + config + ", buyprice=" + buyprice + ", amount="
				+ amount + ", totalmoney=" + totalmoney + ", inputdate="
				+ inputdate + ", inputuserid=" + inputuserid
				+ ", inputUserName=" + inputUserName + ", checkdate="
				+ checkdated + ", checkuserid=" + checkuserid
				+ ", checkUserName=" + checkUserName + ", status=" + status
				+ ", statName=" + statName + ", remark=" + remark + ", orgid="
				+ orgid + ", orgName=" + orgName + "]";
	}
    
    
}