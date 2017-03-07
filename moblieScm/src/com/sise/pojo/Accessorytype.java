package com.sise.pojo;

public class Accessorytype {
    private String accessorytypeid;

    private String typename;

    private String unit;

    private String spec;

    private String manufacturer;

    private String remark;

    private String brand;

    public String getAccessorytypeid() {
        return accessorytypeid;
    }

    public void setAccessorytypeid(String accessorytypeid) {
        this.accessorytypeid = accessorytypeid == null ? null : accessorytypeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }
}