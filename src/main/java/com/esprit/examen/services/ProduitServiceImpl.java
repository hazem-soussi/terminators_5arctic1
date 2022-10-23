package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;



@Service
public class ProduitServiceImpl {
	 @Autowired
	    ProduitRepository prodrepo;
	    public ProduitServiceImpl(ProduitRepository repoprod){
	        this.prodrepo=repoprod;
	    }


	    //add product
	    public Produit addProduct(Produit p){
	        prodrepo.save(p);
	        return p;
	    }

	    //get all product
	    public List<Produit> getAll(){
	        return  prodrepo.findAll();
	    }

	    //edit product
   public Produit updateProduct(Produit p, long id){
        return prodrepo.save(p);
	    }

	    //delete product
	    public void deleteProduct(long id){
	        prodrepo.deleteById(id);
	    }

	    // delete all products
	    public void deleteAll(){
	        prodrepo.deleteAll();
    }



//	    public Optional<Product> findById(Long id) {
	//
//	        return prodrepo.findById(id);
//	    }

}
