package com.italianopizzeria.enums;

public enum ToppingCategory {
    MEAT("Meat"),
    CHEESE("Cheese"),
    REGULAR("Regular"),
    SAUCE("Sauce");

    private final String displayName;

    ToppingCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}