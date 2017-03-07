package com.sise.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class StoCount implements Serializable {

    private static final long serialVersionUID = 1827639638504441958L;

    private String mobtypeid;
    private String accessorytypeid;
    private int amount;
    private Double buyprice;
    private Double cost;
    private Double lossamount;

    public String getMobtypeid() {
        return mobtypeid;
    }

    public void setMobtypeid(String mobtypeid) {
        this.mobtypeid = mobtypeid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
    	BigDecimal b = new BigDecimal(buyprice);
    	double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.buyprice = f1;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
    	//BigDecimal b = new BigDecimal(cost);
    	//double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.cost = Double.valueOf(new java.text.DecimalFormat("#.00").format(cost));
    }

    public Double getLossamount() {
        return lossamount;
    }

    public void setLossamount(Double lossamount) {
    	BigDecimal b = new BigDecimal(lossamount);
    	double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.lossamount = f1;
    }

	public String getAccessorytypeid() {
		return accessorytypeid;
	}

	public void setAccessorytypeid(String accessorytypeid) {
		this.accessorytypeid = accessorytypeid;
	}
    
}
