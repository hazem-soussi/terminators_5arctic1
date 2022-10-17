package com.esprit.examen.services;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;

	 public List<Produit> getAll() {
		return produitRepository.findAll();
	}

	@Transactional
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	

	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}


	

	


}