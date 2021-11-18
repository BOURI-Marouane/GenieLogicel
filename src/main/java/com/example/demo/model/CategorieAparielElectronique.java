package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class CategorieAparielElectronique implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAparielElect;
	@NotNull
	@Size(min = 5, max = 70)
	private String designation;
	private double prix;
	private int quantite;
	private String image;
	private Date registrationDate;
	

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getIdAparielElect() {
		return idAparielElect;
	}

	public void setIdAparielElect(long id) {
		this.idAparielElect = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public CategorieAparielElectronique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieAparielElectronique(long id, String designation, double prix, int quantite, String image) {
		super();
		this.idAparielElect = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}					
				

}
