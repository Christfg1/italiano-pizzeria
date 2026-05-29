package com.italianopizzeria.enums;

public enum SignaturePizzaType {
    CHEESE("Cheese Pizza", "Mozzarella + Marinara"),
    PEPPERONI("Pepperoni Pizza", "Mozzarella + Pepperoni"),
    HAWAIIAN("Hawaiian Pizza", "Mozzarella + Ham + Pineapple"),
    MEAT_LOVERS("Meat Lovers Pizza", "Pepperoni + Sausage + Bacon + Ham"),
    VEGGIE("Veggie Pizza", "Mushrooms + Bell Peppers + Onions + Olives"),
    SUPREME("Supreme Pizza", "Pepperoni + Sausage + Mushrooms + Bell Peppers + Onions"),
    BBQ_CHICKEN("BBQ Chicken Pizza", "BBQ Sauce + Chicken + Onions"),
    ITALIANO_SPECIAL("Italiano Special", "Extra Mozzarella + Pepperoni + Sausage + Mushrooms + Bell Peppers");

    private final String displayName;
    private final String description;

    SignaturePizzaType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}