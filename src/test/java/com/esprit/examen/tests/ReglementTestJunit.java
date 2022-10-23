package com.esprit.examen.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.esprit.examen.entities.Reglement;

public class ReglementTestJunit {
	private Reglement reg;
    @Before
    public void setUp() throws Exception {
        reg = new Reglement ( 1455L , 12.2);
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
