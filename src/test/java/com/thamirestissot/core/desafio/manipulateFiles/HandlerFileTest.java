package com.thamirestissot.core.desafio.manipulateFiles;

import com.thamirestissot.core.desafio.Customer;
import com.thamirestissot.core.desafio.Sale;
import com.thamirestissot.core.desafio.Salesman;
import com.thamirestissot.core.desafio.exceptions.DirectoryNotFoundMessageException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HandlerFileTest {
    HandlerFile handlerFile;

    @Before
    public void setUp() {
        handlerFile = new HandlerFile();
    }

    @Test(expected = DirectoryNotFoundMessageException.class)
    public void readDirectoryTest() throws IOException {
        handlerFile.readDirectory();
    }

    @Test
    public void checkExistsTest() {
        assertFalse(handlerFile.checkExists("/nonexistentDirectory"));
    }

    @Test
    public void readFileTest() {
        assertTrue(handlerFile.readFile("/nonexistentDirectory/nonexistentFile.dat").isEmpty());
    }

    @Test
    public void processLineCodeLine001Test() {
        assertEquals(Salesman.class, handlerFile.processLine("001ç1234567891234çDiegoç50000").getClass());
    }

    @Test
    public void processLineCodeLine002Test() {
        assertEquals(Customer.class, handlerFile.processLine("002ç2345675434544345çJose da SilvaçRural").getClass());
    }

    @Test
    public void processLineCodeLine003Test() {
        assertEquals(Sale.class, handlerFile.processLine("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego").getClass());
    }
}