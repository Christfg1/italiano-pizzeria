package com.italianopizzeria.models;

import com.italianopizzeria.enums.DrinkFlavor;
import com.italianopizzeria.enums.DrinkSize;

public class Drink extends Product {

    private DrinkSize size;
    private DrinkFlavor flavor;

    public Drink(DrinkSize size, DrinkFlavor flavor) {

        super("Drink");

        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    @Override
    public double calculatePrice() {
        return size.getPrice();
    }
}