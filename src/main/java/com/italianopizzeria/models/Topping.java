package com.italianopizzeria.models;

import com.italianopizzeria.enums.ToppingName;

public class Topping {

    private ToppingName toppingName;
    private boolean extra;

    public Topping(ToppingName toppingName, boolean extra) {
        this.toppingName = toppingName;
        this.extra = extra;
    }

    public ToppingName getToppingName() {
        return toppingName;
    }

    public boolean isExtra() {
        return extra;
    }
}