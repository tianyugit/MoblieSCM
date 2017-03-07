package com.sise.pojo;

import java.io.Serializable;

public class Supplier implements Serializable{
	
	private static final long serialVersionUID = 2598823061217433735L;
	
    private String supid;

    private String supname;

    private SupplierType supplierType;

    private String linkman;

    private String tel;

    private String email;

    private String address;

    private String remark;

    public String getSupid() {
        return supid;
    }

    public void setSupid(String supid) {
        this.supid = supid == null ? null : supid.trim();
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname == null ? null : supname.trim();
    }

    public SupplierType getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}

	public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Supplier [supid=" + supid + ", supname=" + supname
				+ ", supplierType=" + supplierType + ", linkman=" + linkman
				+ ", tel=" + tel + ", email=" + email + ", address=" + address
				+ ", remark=" + remark + "]";
	}
    
}