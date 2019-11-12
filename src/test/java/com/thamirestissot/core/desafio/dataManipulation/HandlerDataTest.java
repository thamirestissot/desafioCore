package com.thamirestissot.core.desafio.dataManipulation;

import com.thamirestissot.core.desafio.model.Customer;
import com.thamirestissot.core.desafio.model.Sale;
import com.thamirestissot.core.desafio.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandlerDataTest {
    HandlerData handlerData;

    @Before
    public void setUp() {
        handlerData = new HandlerData();
    }

    @Test
    public void processLineCodeLine001Test() {
        assertEquals(Salesman.class, handlerData.processLine("001ç1234567891234çDiegoç50000").getClass());
    }

    @Test
    public void processLineCodeLine002Test() {
        assertEquals(Customer.class, handlerData.processLine("002ç2345675434544345çJose da SilvaçRural").getClass());
    }

    @Test
    public void processLineCodeLine003Test() {
        assertEquals(Sale.class, handlerData.processLine("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego").getClass());
    }

    @Test
    public void processContentTest() {
        String data = "001ç1234547891234çDiegoç500\n" +
                "001ç3243478865434çRenataç500.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardoPereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-9.10]çDiego\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenata";
        List<Salesman> sellers = new ArrayList<>();
        sellers.add(new Salesman("1234547891234", "Diego",500));
        sellers.add(new Salesman("3243478865434", "Renata",500.99));
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("2345675434544345", "Jose da Silva","Rural"));
        customers.add(new Customer("2345675433444345", "EduardoPereira","Rural"));

        //assertArrayEquals();
    }
}