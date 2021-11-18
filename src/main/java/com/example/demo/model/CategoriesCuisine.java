package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class CategoriesCuisine implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCuisine;
	@NotNull
	@Size(min = 5, max = 70)
	private String designation;
	private double prix;
	private int quantite;
	private String image;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "Date_Commande")
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

	public long getIdCuisine() {
		return idCuisine;
	}

	public void setIdCuisine(int id) {
		this.idCuisine = id;
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

	public CategoriesCuisine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriesCuisine(int id, String designation, double prix, int quantite, String image) {
		super();
		this.idCuisine = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}	
	public CategoriesCuisine(int id, String designation, double prix, int quantite, String image,Date registrationDate) {
		super();
		this.idCuisine = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
		this.registrationDate=registrationDate;
	}
				

}
