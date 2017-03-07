package com.sise.pojo;

public class Customer {
    private String custid;

    private String custname;

    private Customertype customerType;

    private String linkman;

    private String tel;

    private String email;

    private String address;

    private String fax;

    private String remark;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid == null ? null : custid.trim();
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    public Customertype getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Customertype customerType) {
		this.customerType = customerType;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname
				+ ", customerType=" + customerType + ", linkman=" + linkman
				+ ", tel=" + tel + ", email=" + email + ", address=" + address
				+ ", fax=" + fax + ", remark=" + remark + "]";
	}
    
}