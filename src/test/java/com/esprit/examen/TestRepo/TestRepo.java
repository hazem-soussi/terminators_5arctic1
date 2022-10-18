package com.esprit.examen.TestRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;


@DataJpaTest
@RunWith(SpringRunner.class)
public class TestRepo {
	
	@Autowired
	ProduitRepository repo;
	

    @Test
    public void myTest() throws Exception {
        repo.save(new Produit());
    }
    // test methods for CRUD operations...
}
	

    



