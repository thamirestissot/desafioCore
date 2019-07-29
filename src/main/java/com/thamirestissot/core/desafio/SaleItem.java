package com.thamirestissot.core.desafio;

public class SaleItem {
    private Item item;
    private int quantity;

    public SaleItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}