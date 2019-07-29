package com.thamirestissot.core.desafio;

public class Report {
    private int numberOfCustomers, numberOfSalesmen, mostExpensiveSaleId;
    private String worstSalesmanEver;

    public Report(int numberOfCustomers, int numberOfSalesmen, int mostExpensiveSaleId, String worstSalesmanEver) {
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfSalesmen = numberOfSalesmen;
        this.mostExpensiveSaleId = mostExpensiveSaleId;
        this.worstSalesmanEver = worstSalesmanEver;
    }

    public String getMessageReport() {
        StringBuilder message = new StringBuilder();
        message.append("Amount of clients in the input file = ");
        message.append(this.numberOfCustomers);
        message.append("\nAmount of salesman in the input file = ");
        message.append(this.numberOfSalesmen);
        message.append("\nID of the most expensive sale = ");
        if (this.mostExpensiveSaleId == -1)
            message.append("no sale made");
        else
            message.append(this.mostExpensiveSaleId);
        message.append("\nWorst salesman ever = ");
        message.append(this.worstSalesmanEver);
        return message.toString();
    }
}