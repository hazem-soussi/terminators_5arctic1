package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;

		



public String getCodeProduit() {
	return codeProduit;
}

public void setCodeProduit(String codeProduit) {
	this.codeProduit = codeProduit;
}

public String getLibelleProduit() {
	return libelleProduit;
}

public void setLibelleProduit(String libelleProduit) {
	this.libelleProduit = libelleProduit;
}

public Long getIdProduit() {
	return idProduit;
}

public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}


}
	

//}
