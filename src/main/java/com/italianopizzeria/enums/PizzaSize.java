package com.italianopizzeria.enums;

public enum PizzaSize {
    PERSONAL_8("Personal 8\"", 8.50),
    MEDIUM_12("Medium 12\"",12.00),
    LARGE_16("Large\"",16.50);

    private final String displayName;
    private final double basePrice;


    //constructor
    PizzaSize(String displayName, double basePrice){
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    //getters
    public String getDisplayName(){
        return displayName;
    }
    public double getBasePrice(){
        return basePrice;
    }

}
