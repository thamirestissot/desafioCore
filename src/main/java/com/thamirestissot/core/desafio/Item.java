package com.thamirestissot.core.desafio;

public class Item {
    private int id;
    private double price;

    public Item(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}