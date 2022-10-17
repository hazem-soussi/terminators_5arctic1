package com.esprit.examen.entities;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReglementEntityTest {
	private Reglement reg;
    @Before
    public void setUp() throws Exception {
        reg = new Reglement ( 1455L , 12);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testSetID() throws Exception{
        reg.setIdReglement(50L);
        Assert.assertEquals("50L", reg.getIdReglement());

    }


}
