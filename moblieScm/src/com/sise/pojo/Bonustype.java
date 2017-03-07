package com.sise.pojo;

public class Bonustype {
    private String bonustypeid;

    private String tyoename;

    private String remark;

    public String getBonustypeid() {
        return bonustypeid;
    }

    public void setBonustypeid(String bonustypeid) {
        this.bonustypeid = bonustypeid == null ? null : bonustypeid.trim();
    }

    public String getTyoename() {
        return tyoename;
    }

    public void setTyoename(String tyoename) {
        this.tyoename = tyoename == null ? null : tyoename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Bonustype [bonustypeid=" + bonustypeid + ", tyoename="
				+ tyoename + ", remark=" + remark + "]";
	}
    
    
}