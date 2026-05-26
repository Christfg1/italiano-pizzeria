package com.italianopizzeria.services;

import com.italianopizzeria.models.Order;
import com.italianopizzeria.models.Product;

public class OrderManager {

    private Order currentOrder;

    public void startNewOrder() {
        currentOrder = new Order();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void addProduct(Product product) {
        if (currentOrder != null) {
            currentOrder.addProduct(product);
        }
    }

    public void cancelOrder() {
        currentOrder = null;
    }

    public boolean hasActiveOrder() {
        return currentOrder != null;
    }
}