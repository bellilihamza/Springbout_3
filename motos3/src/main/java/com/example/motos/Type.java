package com.example.motos;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity

public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtype;
	private String nomType;
	private String descriptionCat;
	 @JsonIgnore

	@OneToMany(mappedBy = "type")
	private List<Moto> motos;
	public Type() {}
	public Type(String nomCat, String descriptionCat, List<Moto> produits)
	{
	super();
	this.nomType = nomCat;
	this.descriptionCat = descriptionCat;
	this.motos = produits;
	}
	public Long getIdtype() {
		return idtype;
	}
	public void setIdtype(Long idtype) {
		this.idtype = idtype;
	}
	public String getNomType() {
		return nomType;
	}
	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	public String getDescriptionCat() {
		return descriptionCat;
	}
	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}
	
	public List<Moto> getMotos() {
		return motos;
	}
	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}
	@Override
	public String toString() {
		return "Type [idtype=" + idtype + ", nomType=" + nomType + ", descriptionCat=" + descriptionCat + ", produits="
				+ motos + "]";
	}


}
