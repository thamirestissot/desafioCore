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
}
