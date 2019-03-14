package com.example.sandwich.model;

public class CompIng {

    private String component;
    private int ing_numb;
    private String unit;


    public CompIng(String component, Integer ing_numb, String unit){
        this.component = component;
        this.ing_numb = ing_numb;
        this.unit = unit;
    }

    public int getIng_numb() {
        return ing_numb;
    }

    public void setIng_numb(int ing_numb) {
        this.ing_numb = ing_numb;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

