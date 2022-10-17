package com.esprit.examen.repositories;





import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import com.esprit.examen.entities.Reglement;

@Repository
public interface ReglementRepository extends CrudRepository<Reglement, Long>{
	

	
	
}
