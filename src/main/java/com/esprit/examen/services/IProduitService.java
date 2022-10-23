package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Produit;

public interface IProduitService {


	List<Produit> getAll();
	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit p);

	

	

	

	void deleteAll();

}
