package com.esprit.examen.TestEntities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.esprit.examen.entities.Produit;
import com.hades.kerberos.model.Product;

public class TestProduct {
	
	public static final String EXPECTED_codeProduit = "iPHONE";
    public static final String EXPECTED_libelleProduit = "New";
 
   
    private Produit produit;
    
    @Before
    public void setUp() throws Exception {
    	produit = new Produit("iPHONE","New");
    	
    }
    
    @After
    public void tearDown() throws Exception {
    	System.out.println("Test Done!");
    }

    
    @Test
    public void ProDetails() throws Exception {
        Assert.assertEquals(EXPECTED_codeProduit,produit.getCodeProduit());
        Assert.assertEquals(EXPECTED_libelleProduit, produit.getLibelleProduit());
    }
    
    @Test
    public void testSetID() throws Exception{
        produit.setIdProduit(50L);
        Assert.assertEquals("50L",produit.getIdProduit());

    }
    
    @Test
    public void testCreateProd() throws Exception{
        Produit prod= new Produit("test","test");
        Assert.assertEquals("test",prod.getCodeProduit() );
        Assert.assertEquals("test",prod.getLibelleProduit() );
    }


    


}
