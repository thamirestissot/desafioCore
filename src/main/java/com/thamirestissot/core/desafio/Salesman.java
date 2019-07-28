package com.thamirestissot.core.desafio;

import java.util.Comparator;

public class Salesman implements Comparable<Salesman> {
    private final int code=1;
    private String cpf, name;
    private double salary;
    private int totalSales;

    public Salesman(String cpf, String name, double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.totalSales = 0;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getTotalSales() {
        return totalSales;
    }
    public void addSale() {
        this.totalSales++;
    }

    @Override
    public int compareTo(Salesman salesman) {
        if (this.getTotalSales() < salesman.getTotalSales()) {
            return -1;
        }
        if (this.getTotalSales() > salesman.getTotalSales()) {
            return 1;
        }
        return 0;
    }
}
