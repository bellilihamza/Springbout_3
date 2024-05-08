package com.example.motos;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
public class Moto {

	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long idMotot; 
	@NotNull
	@Size (min = 4,max = 15)
	 private String nomMoto; 
	@Min(value = 10)
	 @Max(value = 10000)
	 private Double prixMoto; 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")

	 private Date dateCreation; 
	 @ManyToOne
	 private Type type;

	  

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Moto() { 
	  super(); 
	 } 
	 
	 public Moto(String nomProduit, Double prixProduit, Date dateCreation) { 
	  super(); 
	  this.nomMoto = nomProduit; 
	  this.prixMoto = prixProduit; 
	  this.dateCreation = dateCreation; 
	 }

	public Long getIdMotot() {
		return idMotot;
	}

	public void setIdMotot(Long idMotot) {
		this.idMotot = idMotot;
	}

	public String getNomMoto() {
		return nomMoto;
	}

	public void setNomMoto(String nomMoto) {
		this.nomMoto = nomMoto;
	}

	public Double getPrixMoto() {
		return prixMoto;
	}

	public void setPrixMoto(Double prixMoto) {
		this.prixMoto = prixMoto;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(java.util.Date dateCreation2) {
		this.dateCreation = (Date) dateCreation2;
	}

	 @Override
	public String toString() {
		return "Moto [idMotot=" + idMotot + ", nomMoto=" + nomMoto + ", prixMoto=" + prixMoto + ", dateCreation="
				+ dateCreation + ", type=" + type + "]";
	}
	
	 
}
