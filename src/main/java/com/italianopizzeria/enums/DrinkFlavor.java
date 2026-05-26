package com.italianopizzeria.enums;

public enum DrinkFlavor {
    COKE("Coke"),
    DIET_COKE("Diet Coke"),
    SPRITE("Sprite"),
    FANTA("Fanta"),
    DR_PEPPER("Dr Pepper"),
    WATER("Water");

    private final String displayName;

    DrinkFlavor(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}