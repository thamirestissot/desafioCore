package com.thamirestissot.core.desafio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportTest {

    @Test
    public void getMessageReportTest() {
        Report report = new Report(1, 1, 1, "NameTest");
        assertEquals("Amount of clients in the input file = 1\nAmount of salesman in the input file = 1\nID of the most expensive sale = 1\nWorst salesman ever = NameTest", report.getMessageReport());
    }

    @Test
    public void getMessageReportNoSaleMadeTest() {
        Report report = new Report(1, 1, -1, "");
        assertEquals("Amount of clients in the input file = 1\nAmount of salesman in the input file = 1\nID of the most expensive sale = no sale made\nWorst salesman ever = ", report.getMessageReport());
    }
}