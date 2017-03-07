package com.sise.pojo;

public class User {
    private String userid;
    private String account;
    private String passwd;
    private String email;
    private String remark;
    private String role;
    private String status;
    private String createtime;
    private String lastlogintime;
    private String cvode;
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

    public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime.substring(0, createtime.length()-2);
	}

	public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime.substring(0, lastlogintime.length()-2);;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	public String getCvode() {
		return cvode;
	}

	public void setCvode(String cvode) {
		this.cvode = cvode;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", account=" + account + ", passwd="
				+ passwd + ", email=" + email + ", remark=" + remark
				+ ", role=" + role + ", status=" + status + ", createtime="
				+ createtime + ", lastlogintime=" + lastlogintime + ", cvode="
				+ cvode + "]";
	}

	
	
	
}