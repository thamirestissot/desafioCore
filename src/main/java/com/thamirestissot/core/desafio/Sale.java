package com.thamirestissot.core.desafio;

import java.util.List;

public class Sale implements Comparable<Sale> {
    private final int code = 3;
    private int id;
    private List<SaleItem> items;
    private String salesmanName;

    public Sale(int id, List<SaleItem> items, String salesman) {
        this.id = id;
        this.items = items;
        this.salesmanName = salesman;
    }

    public int getId() {
        return id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    @Override
    public int compareTo(Sale sale) {
        double thisTotal = this.items.stream().mapToDouble(saleItem -> (saleItem.getQuantity() * saleItem.getItem().getPrice())).sum();
        double otherTotal = sale.items.stream().mapToDouble(saleItem -> (saleItem.getQuantity() * saleItem.getItem().getPrice())).sum();
        if (thisTotal > otherTotal) {
            return -1;
        }
        if (thisTotal < otherTotal) {
            return 1;
        }
        return 0;
    }
}
