package com.esprit.examen.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.examen.entities.Produit;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
public Produit findByCodeProduit(String codeProduit);
Optional<Produit> findByLibelleProduit(String libelleProduit);
}

	
	
