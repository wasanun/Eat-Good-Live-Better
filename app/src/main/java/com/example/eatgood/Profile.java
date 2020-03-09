package com.example.eatgood;

public class Profile {
    private String name;
    private String unit;
    private String calories;
    private boolean permission;

    public Profile() {
    }

    public Profile(String name, String unit, String calories, boolean permission) {
        this.name = name;
        this.unit = unit;
        this.calories = calories;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}