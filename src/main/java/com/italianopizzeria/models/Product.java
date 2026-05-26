package com.italianopizzeria.models;

import com.italianopizzeria.interfaces.Priceable;

public abstract class Product implements Priceable {
    private String name;
    public Product(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
