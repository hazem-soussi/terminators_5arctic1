package com.esprit.examen.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reglement implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long idReglement;
	private double montantPaye;
	
	
}
