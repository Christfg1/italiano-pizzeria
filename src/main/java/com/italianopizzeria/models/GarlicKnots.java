package com.italianopizzeria.models;

public class GarlicKnots extends Product {

    private int quantity;

    private static final double PRICE = 1.50;

    public GarlicKnots(int quantity) {

        super("Garlic Knots");

        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculatePrice() {
        return PRICE * quantity;
    }
}