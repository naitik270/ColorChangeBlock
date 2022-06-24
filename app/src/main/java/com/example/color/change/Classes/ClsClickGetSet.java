package com.example.color.change.Classes;

public class ClsClickGetSet {
    boolean blueBtn;
    boolean redBtn;
    String colorValue = "gray";

    public ClsClickGetSet(boolean value, boolean redBtn) {
        this.blueBtn = value;
        this.redBtn = redBtn;
        if (redBtn) {
            colorValue = "red";
        }
    }

    public String getColorValue() {
        return colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }
}
