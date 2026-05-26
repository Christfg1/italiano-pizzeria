package com.italianopizzeria.enums;

public enum CrustType {
    THING("Thin"),
    REGULAR("Regular"),
    THICK("Thick"),
    CAULIFLOWER("Cauliflower"),
    ;

    private final String displayName;

    CrustType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
