package com.italianopizzeria.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {

        double total = 0;

        for (Product product : products) {
            total += product.calculatePrice();
        }

        return total;
    }
}