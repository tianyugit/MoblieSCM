package com.sise.pojo;

public class Color {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}