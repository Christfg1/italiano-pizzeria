package com.italianopizzeria.models;

import com.italianopizzeria.enums.ToppingName;

public class Topping {

    private ToppingName toppingName;
    private boolean extra;

    public Topping(boolean extra, ToppingName toppingName) {
        this.extra = extra;
        this.toppingName = toppingName;
    }
    public ToppingName getToppingName() {
        return toppingName;
    }
    public boolean isExtra(){
        return extra;
    }
}
