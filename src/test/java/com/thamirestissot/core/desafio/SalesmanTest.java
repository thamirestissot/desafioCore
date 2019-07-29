package com.thamirestissot.core.desafio;

import org.junit.Test;

import static org.junit.Assert.*;

public class SalesmanTest {
    Salesman salesman;

    @Test
    public void incrementTotalSaleTest() {
        salesman = new Salesman("000.111.222-99", "NameTest", 6000.00);
        int totalSales = salesman.getTotalSales();
        salesman.incrementTotalSale();
        assertEquals(totalSales + 1, salesman.getTotalSales());
    }
}