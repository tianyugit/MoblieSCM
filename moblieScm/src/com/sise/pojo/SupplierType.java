package com.sise.pojo;

public class SupplierType {
    private String suptypeid;

    private String suptypename;

    private String remark;

    public String getSuptypeid() {
        return suptypeid;
    }

    public void setSuptypeid(String suptypeid) {
        this.suptypeid = suptypeid == null ? null : suptypeid.trim();
    }

    public String getSuptypename() {
        return suptypename;
    }

    public void setSuptypename(String suptypename) {
        this.suptypename = suptypename == null ? null : suptypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "SupplierType [suptypeid=" + suptypeid + ", suptypename="
				+ suptypename + ", remark=" + remark + "]";
	}
    
    
}