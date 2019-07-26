package com.thamirestissot.core.desafio;

import java.util.List;

public class Sale {
    private int id;
    private List<SaleItem> items;
    private Salesman salesman;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(SaleItem item) {
        this.items.add(item);
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
