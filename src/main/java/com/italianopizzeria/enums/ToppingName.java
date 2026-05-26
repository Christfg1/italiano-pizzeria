package com.italianopizzeria.enums;

public enum ToppingName {

    // Meats
    PEPPERONI("Pepperoni", ToppingCategory.MEAT),
    SAUSAGE("Sausage", ToppingCategory.MEAT),
    HAM("Ham", ToppingCategory.MEAT),
    BACON("Bacon", ToppingCategory.MEAT),
    CHICKEN("Chicken", ToppingCategory.MEAT),
    MEATBALL("Meatball", ToppingCategory.MEAT),

    // Cheeses
    MOZZARELLA("Mozzarella", ToppingCategory.CHEESE),
    PARMESAN("Parmesan", ToppingCategory.CHEESE),
    RICOTTA("Ricotta", ToppingCategory.CHEESE),
    GOAT_CHEESE("Goat Cheese", ToppingCategory.CHEESE),
    BUFFALO_CHEESE("Buffalo Cheese", ToppingCategory.CHEESE),

    // Regular toppings
    ONIONS("Onions", ToppingCategory.REGULAR),
    MUSHROOMS("Mushrooms", ToppingCategory.REGULAR),
    BELL_PEPPERS("Bell Peppers", ToppingCategory.REGULAR),
    OLIVES("Olives", ToppingCategory.REGULAR),
    TOMATOES("Tomatoes", ToppingCategory.REGULAR),
    SPINACH("Spinach", ToppingCategory.REGULAR),
    BASIL("Basil", ToppingCategory.REGULAR),
    PINEAPPLE("Pineapple", ToppingCategory.REGULAR),
    ANCHOVIES("Anchovies", ToppingCategory.REGULAR);

    private final String displayName;
    private final ToppingCategory category;

    ToppingName(String displayName, ToppingCategory category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ToppingCategory getCategory() {
        return category;
    }
}