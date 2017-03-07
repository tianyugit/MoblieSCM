package com.sise.pojo;

import java.io.Serializable;

public class MobTonus implements Serializable {

    private static final long serialVersionUID = 6552897622196938591L;
    
    private String id;
    private String mobTypeId;
    private String bonusTypeId;
    private Double money;

    public String getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(String bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

  

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobTypeId() {
        return mobTypeId;
    }

    public void setMobTypeId(String mobTypeId) {
        this.mobTypeId = mobTypeId;
    }

	@Override
	public String toString() {
		return "MobTonus [id=" + id + ", mobTypeId=" + mobTypeId
				+ ", bonusTypeId=" + bonusTypeId + ", Money=" + money + "]";
	}


}
