package com.italianopizzeria.services;

import com.italianopizzeria.enums.PizzaSize;
import com.italianopizzeria.enums.ToppingCategory;
import com.italianopizzeria.models.Pizza;
import com.italianopizzeria.models.Topping;

public class PriceCalculator {

    public static double calculatePizzaPrice(Pizza pizza) {
        double total = pizza.getSize().getBasePrice();

        for (Topping topping : pizza.getToppings()) {
            total += calculateToppingPrice(pizza.getSize(), topping);
        }

        if (pizza.hasStuffedCrust()) {
            total += 2.00;
        }

        return total;
    }

    private static double calculateToppingPrice(PizzaSize size, Topping topping) {
        ToppingCategory category = topping.getToppingName().getCategory();

        if (category == ToppingCategory.REGULAR) {
            return 0;
        }

        if (category == ToppingCategory.MEAT) {
            if (topping.isExtra()) {
                return switch (size) {
                    case PERSONAL_8 -> 0.50;
                    case MEDIUM_12 -> 1.00;
                    case LARGE_16 -> 1.50;
                };
            }

            return switch (size) {
                case PERSONAL_8 -> 1.00;
                case MEDIUM_12 -> 2.00;
                case LARGE_16 -> 3.00;
            };
        }

        if (category == ToppingCategory.CHEESE) {
            if (topping.isExtra()) {
                return switch (size) {
                    case PERSONAL_8 -> 0.30;
                    case MEDIUM_12 -> 0.60;
                    case LARGE_16 -> 0.90;
                };
            }

            return switch (size) {
                case PERSONAL_8 -> 0.75;
                case MEDIUM_12 -> 1.50;
                case LARGE_16 -> 2.25;
            };
        }

        return 0;
    }
}