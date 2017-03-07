package com.sise.pojo;

public class JsonBean_data {
	private String unit;
	private String value;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "JsonBean_data [unit=" + unit + ", value=" + value + "]";
	}

}
