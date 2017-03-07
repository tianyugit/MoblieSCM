package com.sise.pojo;

public class SupMobstocksnout {
    private String id;

    private String invoiceid;

    private String sn1;

    private String sn2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1 == null ? null : sn1.trim();
    }

    public String getSn2() {
        return sn2;
    }

    public void setSn2(String sn2) {
        this.sn2 = sn2 == null ? null : sn2.trim();
    }
}