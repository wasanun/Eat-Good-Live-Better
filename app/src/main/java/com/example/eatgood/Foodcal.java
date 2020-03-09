package com.example.eatgood;

public class Foodcal {
    private String namefood;
    private String unit;
    private String calories;

    public Foodcal() {
    }

    public Foodcal(String namefood, String unit, String calories) {
        this.namefood = namefood;
        this.unit = unit;
        this.calories = calories;
    }

    public String getNamefood() {
        return namefood;
    }

    public void setNamefood(String namefood) {
        this.namefood = namefood;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
