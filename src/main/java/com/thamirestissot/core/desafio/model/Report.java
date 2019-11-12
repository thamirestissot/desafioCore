package com.thamirestissot.core.desafio.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
    private int numberOfCustomers, numberOfSalesmen, mostExpensiveSaleId;
    private Salesman worstSalesmanEver;

    public Report(int numberOfCustomers, int numberOfSalesmen, int mostExpensiveSaleId, Salesman worstSalesmanEver) {
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfSalesmen = numberOfSalesmen;
        this.mostExpensiveSaleId = mostExpensiveSaleId;
        this.worstSalesmanEver = worstSalesmanEver;
    }

    public Report(List<Object> objects) {
        List<Salesman> salesmen = getList(objects, Salesman.class);
        List<Customer> customers = getList(objects, Customer.class);
        List<Sale> sales = getList(objects, Sale.class);
        this.numberOfCustomers = customers.size();
        this.numberOfSalesmen = salesmen.size();
        if (!sales.isEmpty()) {
            Collections.sort(sales);
            this.mostExpensiveSaleId = sales.get(0).getId();
            for (Sale sale : sales) {
                salesmen.stream().filter(salesman -> salesman.getName().equals(sale.getSalesmanName())).forEach(salesman -> salesman.incrementTotalSale());
            }
            Collections.sort(salesmen);
            this.worstSalesmanEver = salesmen.get(0);
        }
    }

    private <E> List<E> getList(List<Object> list, Class myclass) {
        return list.stream().filter(o -> o.getClass() == myclass).map(o -> (E) o).collect(Collectors.toList());
    }
}