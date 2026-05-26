package com.italianopizzeria.models;
import com.italianopizzeria.enums.CrustType;
import com.italianopizzeria.enums.PizzaSize;
import com.italianopizzeria.enums.SauceType;

import java.util.ArrayList;
import java.util.List;
public class Pizza extends Product {
    private PizzaSize size;
    private CrustType crustType;
    private List<Topping> toppings;
    private List<SauceType> sauces;
    private boolean stuffedCrust;

    public Pizza(PizzaSize size, CrustType crustType){
        super("Pizza");
        this.size = size;
        this.crustType = crustType;

        toppings = new ArrayList<>();
        sauces = new ArrayList<>();

        stuffedCrust = false;

    }
    public PizzaSize getSize() {
        return size;
    }

    public CrustType getCrustType() {
        return crustType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<SauceType> getSauces() {
        return sauces;
    }

    public boolean hasStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSauce(SauceType sauce) {
        sauces.add(sauce);
    }

    @Override
    public double calculatePrice() {
        return size.getBasePrice();
    }
}
